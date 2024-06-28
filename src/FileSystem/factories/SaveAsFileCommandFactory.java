package FileSystem.factories;

import FileSystem.commands.SaveAsFileCommand;
import FileSystem.invoker.FileState;
import contracts.Command;
import contracts.CommandFactory;

public class SaveAsFileCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        if (!FileState.isOpen()) {
            System.out.println("File not open. Please open a file first using 'open <filePath>' command.");
            return null;
        }
        if (args.length != 1) {
            System.out.println("Invalid arguments for saveas command. Usage: saveas <newFilePath>");
            return null;
        }
        return new SaveAsFileCommand(args[0]);
    }
}
