package addtional_commands.commands;

import addtional_commands.logic.unavailables.UnavailableRoom;
import addtional_commands.logic.unavailables.UnavailableRoomService;
import contracts.Command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UnavailableCommand implements Command {
    @Override
    public void execute(String... args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Insufficient arguments to make room unavailable.");
        }
        int roomNumber = Integer.parseInt(args[0]);
        LocalDate startDate = LocalDate.parse(args[1], DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endDate = LocalDate.parse(args[2], DateTimeFormatter.ISO_LOCAL_DATE);
        String note = args[3];

        UnavailableRoom room = new UnavailableRoom(roomNumber, startDate, endDate, note);
        UnavailableRoomService.makeUnavailable(room);
    }
}
