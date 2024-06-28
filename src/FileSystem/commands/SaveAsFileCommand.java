package FileSystem.commands;

import FileSystem.invoker.FileManager;

import java.io.*;

public class SaveAsFileCommand extends AbstractFileCommand {
    private String anotherFile;

    public SaveAsFileCommand(String anotherFile) {
        super(FileManager.getCurrentFile());
        this.anotherFile = anotherFile;
    }

    @Override
    public void execute(String... args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileName()));
             FileWriter writer = new FileWriter(anotherFile, false)) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            System.out.println("File saved as " + anotherFile + " successfully!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + getFileName(), e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading or writing file: " + getFileName(), e);
        }
    }
}
