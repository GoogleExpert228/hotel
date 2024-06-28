package FileSystem.factories;

import FileSystem.commands.CloseFileCommand;
import FileSystem.invoker.FileState;
import contracts.Command;
import contracts.CommandFactory;

public class CloseFileCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        if (!FileState.isOpen()) {
            System.out.println("No file is currently open.");
            return null;
        }
        if (args.length != 0) {
            System.out.println("Invalid arguments for close command. This command takes no arguments.");
            return null;
        }
        FileState.setOpen(false);
        return new CloseFileCommand();
    }
}
