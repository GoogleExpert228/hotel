package addtional_commands.commands;

import addtional_commands.logic.Availability;
import contracts.Command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AvailabilityCommand implements Command {
    @Override
    public void execute(String... args) {
        if (args.length == 1) {
            try {
                LocalDate checkDate = LocalDate.parse(args[0], DateTimeFormatter.ISO_LOCAL_DATE);
                Availability.operation(checkDate);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use: availability <YYYY-MM-DD>");
            }
        } else {
            System.out.println("Insufficient parameters. Please use: availability <YYYY-MM-DD>");
        }
    }
}
