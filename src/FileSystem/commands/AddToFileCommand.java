package FileSystem.commands;

import contracts.Command;

import java.io.FileWriter;
import java.io.IOException;

public class AddToFileCommand implements Command {
    @Override
    public void execute(String... args) {
        if (args.length < 2) {
            System.out.println("Invalid arguments for add command. Usage: add <filename> <content>");
            return;
        }
        String filename = args[0];
        String content = args[1];

        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Line '" + content + "' added to file '" + filename + "'\n");
            System.out.println("Line '" + content + "' added to file '" + filename + "'");
        } catch (IOException e) {
            System.out.println("Error writing to file '" + filename + "': " + e.getMessage());
        }
    }
}
