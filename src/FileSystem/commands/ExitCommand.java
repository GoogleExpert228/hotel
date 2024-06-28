package FileSystem.commands;

import contracts.Command;

public class ExitCommand implements Command {
    @Override
    public void execute(String... args) {
        System.out.println("Exiting program...");
        System.exit(0); // Terminate program with success exit code
    }
}
