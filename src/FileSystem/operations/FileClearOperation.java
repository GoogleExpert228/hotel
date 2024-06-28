package FileSystem.operations;

import contracts.FileOperation;

import java.io.FileWriter;
import java.io.IOException;

class FileClearOperation implements FileOperation {
    @Override
    public void operation(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            // This opens the file for writing, but since we don't write anything,
            // it effectively clears the content.
        } catch (IOException e) {
            throw new RuntimeException("Error clearing file: " + filePath, e);
        }
    }
}
