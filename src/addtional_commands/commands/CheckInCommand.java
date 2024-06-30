package addtional_commands.commands;

import addtional_commands.logic.registrations.Registration;
import addtional_commands.logic.registrations.RegistrationService;
import contracts.Command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CheckInCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length >= 4) {
            try {
                int roomNumber = Integer.parseInt(args[0]);
                LocalDate checkInDate = LocalDate.parse(args[1], DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate checkOutDate = LocalDate.parse(args[2], DateTimeFormatter.ISO_LOCAL_DATE);
                String note = args[3];
                int guestsNumber = args.length == 5 ? Integer.parseInt(args[4]) : 2;

                Registration registration = new Registration(roomNumber, checkInDate, checkOutDate, note, guestsNumber);
                RegistrationService.checkIn(registration);

                System.out.printf("Registered room number %d from %s to %s \n",
                        roomNumber, checkInDate, checkOutDate);
            } catch (NumberFormatException | DateTimeParseException e) {
                System.out.println("Invalid input format. Please use: checkin <room> <from> <to> <note> [<guests>]");
            }
        } else {
            System.out.println("Insufficient parameters. Please use: checkin <room> <from> <to> <note> [<guests>]");
        }
    }
}
