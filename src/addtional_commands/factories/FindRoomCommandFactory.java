package addtional_commands.factories;

import addtional_commands.commands.FindRoomCommand;
import contracts.Command;
import contracts.CommandFactory;

public class FindRoomCommandFactory implements CommandFactory {

    @Override
    public Command createCommand(String[] args) {
        return new FindRoomCommand();
    }
}
