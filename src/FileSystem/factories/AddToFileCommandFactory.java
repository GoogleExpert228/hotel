package FileSystem.factories;

import FileSystem.commands.AddToFileCommand;
import contracts.Command;
import contracts.CommandFactory;

public class AddToFileCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        if (args.length < 2) {
            System.out.println("Invalid arguments for add command. Usage: add <filename> <content>");
            return null;
        }
        return new AddToFileCommand();
    }
}
