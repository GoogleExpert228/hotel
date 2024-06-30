package addtional_commands.factories;

import addtional_commands.commands.UnavailableCommand;
import contracts.Command;
import contracts.CommandFactory;

public class UnavailableCommandFactory implements CommandFactory {

    @Override
    public Command createCommand(String[] args) {
        return new UnavailableCommand();
    }
}
