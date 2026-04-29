import pytest
from labgrid.util.timeout import Timeout

@pytest.fixture(scope="function")
def in_shell(strategy, capsys):
    with capsys.disabled():
        strategy.transition("shell")

def test_shell(target, in_shell):
    command = target.get_driver("ShellDriver")
    timeout_obj = Timeout(60.0*60)
    stdout, stderr, returncode = command.run("/usr/bin/ptest-runner", timeout=timeout_obj.remaining)
    print(timeout_obj.remaining)
    assert returncode == 0
    assert stdout
    assert not stderr

