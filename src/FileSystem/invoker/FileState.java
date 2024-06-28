package FileSystem.invoker;

public class FileState {
    private static boolean isOpen = false;

    public static boolean isOpen() {
        return isOpen;
    }

    public static void setOpen(boolean isOpen) {
        FileState.isOpen = isOpen;
    }
}
