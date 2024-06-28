package FileSystem.factories;

import FileSystem.commands.HelpCommand;
import contracts.Command;
import contracts.CommandFactory;

public class HelpCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        if (args.length != 0) {
            System.out.println("Invalid arguments for help command. This command takes no arguments.");
            return null;
        }
        return new HelpCommand();
    }
}
