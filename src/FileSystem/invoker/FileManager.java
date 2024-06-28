package FileSystem.invoker;

public class FileManager {
    private static String currentFile;

    public static void setCurrentFile(String fileName) {
        currentFile = fileName;
    }

    public static String getCurrentFile() {
        return currentFile;
    }
}
