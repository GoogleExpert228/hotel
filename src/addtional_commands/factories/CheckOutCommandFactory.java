package addtional_commands.factories;

import addtional_commands.commands.CheckOutCommand;
import contracts.Command;
import contracts.CommandFactory;

public class CheckOutCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        return new CheckOutCommand();
    }
}
