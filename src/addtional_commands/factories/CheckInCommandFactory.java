package addtional_commands.factories;

import addtional_commands.commands.CheckInCommand;
import contracts.Command;
import contracts.CommandFactory;

public class CheckInCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        return new CheckInCommand();
    }
}
