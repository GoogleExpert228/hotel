package FileSystem.factories;

import FileSystem.commands.OpenFileCommand;
import FileSystem.invoker.FileState;
import contracts.Command;
import contracts.CommandFactory;

public class OpenFileCommandFactory implements CommandFactory {
    private static final String[] ALLOWED_FILES = {"registrations.xml", "history.xml", "unavailable.xml"};

    @Override
    public Command createCommand(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid arguments for open command. Usage: open <filePath>");
            return null;
        }
        String fileName = args[0];
        for (String allowedFile : ALLOWED_FILES) {
            if (allowedFile.equals(fileName)) {
                FileState.setOpen(true); // Set the file open state
                return new OpenFileCommand(fileName);
            }
        }
        System.out.println("Invalid file: " + fileName + ". Here is the list of allowed files: registrations.xml, history.xml, unavailable.xml.");
        return null;
    }
}
