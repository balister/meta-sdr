import pytest


@pytest.fixture(scope="function")
def in_shell(strategy, capsys):
    with capsys.disabled():
        strategy.transition("shell")


def test_shell(target, in_shell):
    # command = target.get_driver(CommandProtocol)
    command = target.get_driver("ShellDriver")
    stdout, stderr, returncode = command.run("cat /proc/version")
    assert returncode == 0
    assert stdout
    assert not stderr
    assert "Linux" in stdout[0]

