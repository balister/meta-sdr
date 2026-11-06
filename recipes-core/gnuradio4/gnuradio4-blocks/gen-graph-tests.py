#!/usr/bin/env python3
# Turn the graph-file cases gr_add_graph_test() registers with ctest (a
# rungraph command line plus the properties that say how it passes) into a
# shell list run-ptest runs on the target, and copy the graph files they read.
#
# usage: gen-graph-tests.py <B> <S> <rungraph> <ptest dir>
#
# Fails on anything it does not know how to carry over, so that a new kind of
# case upstream shows up as a build error rather than as a test that quietly
# checks something else.

import os
import re
import shlex
import shutil
import sys

B, S, RUNGRAPH, DEST = (os.path.normpath(a) for a in sys.argv[1:5])

# properties a case may carry, and those run-ptest ignores
KNOWN = {"ENVIRONMENT_MODIFICATION", "PASS_REGULAR_EXPRESSION", "WILL_FAIL", "TIMEOUT"}
IGNORED = {"LABELS", "_BACKTRACE_TRIPLES"}
ESCAPES = {"n": "\n", "t": "\t", "r": "\r", "0": "\0"}


def die(msg):
    sys.exit("gen-graph-tests.py: " + msg)


def tokens(text):
    """Split the arguments of one CTestTestfile command into raw tokens.
    Quoted arguments keep their escapes, so ';' and '\\;' stay apart."""
    i, out = 0, []
    while i < len(text):
        c = text[i]
        if c.isspace():
            i += 1
        elif c == '"':
            j = i + 1
            while text[j] != '"':
                j += 2 if text[j] == "\\" else 1
            out.append(("q", text[i + 1:j]))
            i = j + 1
        elif c == "[" and re.match(r"\[=*\[", text[i:]):
            eq = re.match(r"\[(=*)\[", text[i:]).group(1)
            end = text.index("]" + eq + "]", i)
            out.append(("b", text[i + len(eq) + 2:end]))
            i = end + len(eq) + 2
        else:
            j = i
            while j < len(text) and not text[j].isspace():
                j += 1
            out.append(("u", text[i:j]))
            i = j
    return out


def unescape(s):
    return re.sub(r"\\(.)", lambda m: ESCAPES.get(m.group(1), m.group(1)), s)


def value(tok):
    kind, s = tok
    return s if kind == "b" else unescape(s)


def as_list(tok):
    """A property value as the CMake list ctest reads; a '\\;' stays in its item."""
    kind, s = tok
    if kind == "b":
        return s.split(";")
    return [unescape(p) for p in re.split(r"(?<!\\);", s)]


def commands(path):
    """Yield (command, args) for each add_test/set_tests_properties call."""
    text = open(path).read()
    for m in re.finditer(r"^(add_test|set_tests_properties)\(", text, re.M):
        i, depth, quote = m.end(), 1, False
        j = i
        while depth:
            c = text[j]
            if quote:
                if c == "\\":
                    j += 1
                elif c == '"':
                    quote = False
            elif c == '"':
                quote = True
            elif c == "[" and re.match(r"\[=*\[", text[j:]):
                eq = re.match(r"\[(=*)\[", text[j:]).group(1)
                j = text.index("]" + eq + "]", j) + len(eq) + 1
            elif c == "(":
                depth += 1
            elif c == ")":
                depth -= 1
            j += 1
        yield m.group(1), tokens(text[i:j - 1])


def target_arg(arg, graphs):
    """Map a build-host path in an argument to its place under the ptest dir."""
    if arg.startswith(S + "/"):
        rel = os.path.relpath(arg, S)
        graphs.add(rel)
        return rel
    if B in arg or S in arg:
        die("argument %r names a build-tree path" % arg)
    return arg


def ere(regex):
    """A ctest regex as one grep -E pattern. grep matches line by line, so a
    class that only keeps a match on one line ([^\\n]) is any character, and
    a newline that ends the regex or an alternative is the end of the line."""
    regex = regex.replace("[^\n]", ".")
    # CMake regexes escape a quote, which an ERE leaves undefined
    regex = regex.replace('\\"', '"')
    # CMake regexes have no {m,n} interval, so a brace is a literal brace
    regex = re.sub(r"(?<!\\)([{}])", r"[\1]", regex)
    regex = re.sub(r"\n(?=[|)]|$)", "$", regex)
    if "\n" in regex:
        die("regex %r spans lines" % regex)
    return regex


cases = {}
graphs = set()
for root, _, files in sorted(os.walk(B)):
    if "CTestTestfile.cmake" not in files:
        continue
    path = os.path.join(root, "CTestTestfile.cmake")
    for cmd, toks in commands(path):
        name = value(toks[0])
        if cmd == "add_test":
            argv = [value(t) for t in toks[1:]]
            if argv[0] != RUNGRAPH:
                continue
            if name in cases:
                die("case %s registered twice" % name)
            cases[name] = {"argv": [target_arg(a, graphs) for a in argv[1:]], "props": {}}
        elif name in cases:
            if value(toks[1]) != "PROPERTIES":
                die("%s: set_tests_properties of several cases" % name)
            props = toks[2:]
            for k, v in zip(props[0::2], props[1::2]):
                cases[name]["props"][value(k)] = v

if not cases:
    die("no rungraph cases in %s; did configure find rungraph?" % B)

lines = []
for name in sorted(cases):
    case = cases[name]
    props = case["props"]
    unknown = set(props) - KNOWN - IGNORED
    if unknown:
        die("%s: unsupported properties %s" % (name, sorted(unknown)))
    for entry in as_list(props.get("ENVIRONMENT_MODIFICATION", ("q", ""))):
        var = entry.split("=", 1)[0]
        # run-ptest sets both for every case: the plugin directories to the
        # installed plugins, the library path to the installed libraries
        if entry and var not in ("GNURADIO4_PLUGIN_DIRECTORIES", "LD_LIBRARY_PATH"):
            die("%s: unsupported environment %r" % (name, entry))
    if "PASS_REGULAR_EXPRESSION" in props:
        expect = "match"
        pattern = "|".join("(%s)" % ere(r) for r in as_list(props["PASS_REGULAR_EXPRESSION"]) if r)
    elif value(props.get("WILL_FAIL", ("q", "FALSE"))).upper() in ("TRUE", "ON", "1", "YES"):
        expect, pattern = "fail", ""
    else:
        expect, pattern = "pass", ""
    timeout = value(props.get("TIMEOUT", ("q", "60")))
    if not timeout.isdigit():
        die("%s: timeout %r" % (name, timeout))
    argv = " ".join(shlex.quote(a) for a in case["argv"])
    lines.append("graph_test %s %s %s %s %s"
                 % (shlex.quote(name), expect, timeout, shlex.quote(pattern), argv))

for rel in sorted(graphs):
    os.makedirs(os.path.join(DEST, os.path.dirname(rel)), exist_ok=True)
    shutil.copyfile(os.path.join(S, rel), os.path.join(DEST, rel))

with open(os.path.join(DEST, "graph-tests.sh"), "w") as f:
    f.write("# Generated by gen-graph-tests.py from the ctest graph-file cases.\n")
    f.write("# graph_test <name> <pass|fail|match> <timeout> <pattern> <rungraph arguments...>\n")
    f.write("\n".join(lines) + "\n")

print("gen-graph-tests.py: %d cases, %d graph files" % (len(lines), len(graphs)))
