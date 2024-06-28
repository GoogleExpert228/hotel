package FileSystem.factories;

import FileSystem.commands.ExitCommand;
import FileSystem.invoker.FileManager;
import contracts.Command;
import contracts.CommandFactory;

public class ExitCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        if (args.length != 0) {
            System.out.println("Invalid arguments for exit command. This command takes no arguments.");
            return null;
        } else {
            if (FileManager.getCurrentFile().equalsIgnoreCase("regs.xml")) {
                return new ExitCommand();
            } else {
                System.out.println("You must open this file: regs.xml");
                return null;
            }

        }
    }
}
