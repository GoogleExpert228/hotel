package FileSystem.commands;

import FileSystem.invoker.FileManager;
import FileSystem.invoker.FileState;
import contracts.Command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OpenFileCommand implements Command {
    private final String fileName;

    public OpenFileCommand(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute(String... args) {
        File fileForOpening = new File(fileName);
        if (fileForOpening.exists()) {
            FileManager.setCurrentFile(fileName);
            System.out.println("File opened successfully!");
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                FileState.setOpen(true); // Set the file open state
            } catch (IOException e) {
                throw new RuntimeException("Error reading file: " + fileName, e);
            }
        } else {
            System.out.println("File not found: " + fileName);
        }
    }
}
