package FileSystem.operations;

import contracts.FileOperation;

import java.io.FileWriter;
import java.io.IOException;

class FileWriteOperation implements FileOperation {
    private String newContent;

    public FileWriteOperation(String newContent) {
        this.newContent = newContent;
    }

    @Override
    public void operation(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(newContent);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}
