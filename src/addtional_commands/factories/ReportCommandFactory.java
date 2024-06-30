package addtional_commands.factories;

import addtional_commands.commands.ReportCommand;
import contracts.Command;
import contracts.CommandFactory;

public class ReportCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        return new ReportCommand();
    }
}
