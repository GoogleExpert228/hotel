package addtional_commands.commands;

import addtional_commands.logic.registrations.RegistrationService;
import contracts.Command;

public class CheckOutCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            try {
                int roomNumber = Integer.parseInt(args[0]);
                RegistrationService.checkOut(roomNumber);
            } catch (NumberFormatException e) {
                System.out.println("Invalid room number. Please use: checkout <room>");
            }
        } else {
            System.out.println("Insufficient parameters. Please use: checkout <room>");
        }
    }
}
