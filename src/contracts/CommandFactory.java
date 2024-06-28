package contracts;

public interface CommandFactory {
    Command createCommand(String[] args);
}
