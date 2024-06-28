package FileSystem.factories;

import FileSystem.commands.SaveFileCommand;
import FileSystem.invoker.FileState;
import contracts.Command;
import contracts.CommandFactory;

public class SaveFileCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        if (!FileState.isOpen()) {
            System.out.println("File not open. Please open a file first using 'open <filePath>' command.");
            return null;
        }
        if (args.length != 0) {
            System.out.println("Invalid arguments for save command. This command takes no arguments.");
            return null;
        }
        return new SaveFileCommand();
    }
}
