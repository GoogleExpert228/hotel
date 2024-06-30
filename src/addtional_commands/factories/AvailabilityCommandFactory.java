package addtional_commands.factories;

import addtional_commands.commands.AvailabilityCommand;
import contracts.Command;
import contracts.CommandFactory;

public class AvailabilityCommandFactory implements CommandFactory {

    @Override
    public Command createCommand(String[] args) {
        return new AvailabilityCommand();
    }
}
