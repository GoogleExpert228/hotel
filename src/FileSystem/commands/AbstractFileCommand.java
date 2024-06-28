package FileSystem.commands;

import contracts.Command;

public abstract class AbstractFileCommand implements Command {
    protected static StringBuilder contentWhenFileOpening = new StringBuilder();
    protected static StringBuilder contentWhenFileClosing = new StringBuilder();
    protected static boolean isFileSaved = false;
    protected String fileName;

    public AbstractFileCommand(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
