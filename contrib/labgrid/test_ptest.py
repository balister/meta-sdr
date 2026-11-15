import pytest
from labgrid.util.timeout import Timeout

@pytest.fixture(scope="function")
def in_shell(strategy, capsys):
    with capsys.disabled():
        strategy.transition("shell")

def test_shell(target, in_shell):
    command = target.get_driver("ShellDriver")
    # Some ptests run for minutes without output on slow targets (the
    # BeagleV-Fire's U54 cores ran gnuradio4-blocks' qa_FractionalDelay for
    # more than ptest-runner's default 300 s silent), so give each test the
    # timeout testimage uses for qemu, and the whole run four hours.
    timeout_obj = Timeout(4*60.0*60)
    stdout, stderr, returncode = command.run("/usr/bin/ptest-runner -t 1800", timeout=timeout_obj.remaining)
    # Show the ptest results in the job log, not just the return code.
    print("\n".join(stdout))
    print("\n".join(stderr))
    print(timeout_obj.remaining)
    assert returncode == 0
    assert stdout
    assert not stderr

