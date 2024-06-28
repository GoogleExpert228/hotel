package FileSystem.commands;

import FileSystem.invoker.FileManager;

public class SaveFileCommand extends AbstractFileCommand {
    public SaveFileCommand() {
        super(FileManager.getCurrentFile());
    }

    @Override
    public void execute(String... args) {
        AbstractFileCommand.isFileSaved = true;
        AbstractFileCommand.contentWhenFileClosing = AbstractFileCommand.contentWhenFileOpening;
        System.out.println("File saved successfully!");
    }
}
