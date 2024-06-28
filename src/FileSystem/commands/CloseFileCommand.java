package FileSystem.commands;

import FileSystem.invoker.FileManager;
import FileSystem.invoker.FileState;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CloseFileCommand extends AbstractFileCommand {
    public CloseFileCommand() {
        super(FileManager.getCurrentFile());
    }

    @Override
    public void execute(String... args) {
        Scanner scanner = new Scanner(System.in);

        if (AbstractFileCommand.isFileSaved) {
            System.out.println("File closed successfully!");
        } else {
            System.out.println("Do you want to save the file before closing it?");
            System.out.print("Enter answer y/n: ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("y")) {
                AbstractFileCommand.isFileSaved = true;
                System.out.println("File closed and saved successfully!");
            } else if (answer.equalsIgnoreCase("n")) {
                if (!AbstractFileCommand.contentWhenFileOpening.toString().equals(AbstractFileCommand.contentWhenFileClosing.toString())) {
                    try (FileWriter writer = new FileWriter(fileName, false)) {
                        writer.write(AbstractFileCommand.contentWhenFileOpening.toString());
                    } catch (IOException e) {
                        throw new RuntimeException("Error writing to file: " + fileName, e);
                    }
                    System.out.println("File closed successfully with changes!");
                } else {
                    System.out.println("File closed successfully!");
                }
                AbstractFileCommand.isFileSaved = false;
            } else {
                System.out.println("Invalid answer, please answer either y (yes) or n (no)!");
            }
        }
        FileState.setOpen(false); // Set the file closed state
    }
}
