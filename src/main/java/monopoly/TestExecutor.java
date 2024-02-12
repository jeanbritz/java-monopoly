package monopoly;

import java.io.IOException;

public class TestExecutor {

    private void test1(String command) throws IOException, IOException {
        String[] cmd = new String[3];
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
        } else {
            cmd[0] = "/bin/bash";
            cmd[1] = "-c";
        }
        cmd[2] = command;

        // ruleid: command-injection-process-builder
        ProcessBuilder builder = new ProcessBuilder(cmd);
        builder.redirectErrorStream(true);
        Process proc = builder.start();
    }

    public String test2(String userInput) {
        ProcessBuilder builder = new ProcessBuilder();
        // ruleid: command-injection-process-builder
        builder.command(userInput);
        return "foo";
    }

    public String test3(String userInput) {
        ProcessBuilder builder = new ProcessBuilder();
        // ruleid: command-injection-process-builder
        builder.command("bash", "-c", userInput);
        return "foo";
    }

    public String test4(String userInput) {
        ProcessBuilder builder = new ProcessBuilder();
        // ruleid: command-injection-process-builder
        builder.command("cmd", "/c", userInput);
        return "foo";
    }

    public String okTest() {
        ProcessBuilder builder = new ProcessBuilder();
        // ok: command-injection-process-builder
        builder.command("bash", "-c", "ls");
        return "foo";
    }


}
