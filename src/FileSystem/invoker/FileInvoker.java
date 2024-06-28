package FileSystem.invoker;

import contracts.Command;

public class FileInvoker {
    private Command command;

    public FileInvoker(Command command) {
        this.command = command;
    }

    public void execute(String... args) {
        this.command.execute(args);
    }
}
