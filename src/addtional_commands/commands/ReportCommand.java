package addtional_commands.commands;

import addtional_commands.logic.Report;
import contracts.Command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ReportCommand implements Command {
    @Override
    public void execute(String... args) {
        if (args.length == 2) {
            try {
                LocalDate startDate = LocalDate.parse(args[0], DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate endDate = LocalDate.parse(args[1], DateTimeFormatter.ISO_LOCAL_DATE);
                Report.usedRooms(startDate, endDate);
            } catch (DateTimeParseException e) {
                System.err.println("Invalid input format. Please use: report <startDate> <endDate>");
            }
        } else {
            System.err.println("Insufficient parameters. Please use: report <startDate> <endDate>");
        }
    }
}
