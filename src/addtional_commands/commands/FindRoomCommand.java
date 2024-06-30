package addtional_commands.commands;

import addtional_commands.logic.FindRoom;
import contracts.Command;
import hotel_rooms.Room;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FindRoomCommand implements Command {
    @Override
    public void execute(String... args) {
        if (args.length == 3) {
            try {
                int beds = Integer.parseInt(args[0]);
                LocalDate fromDate = LocalDate.parse(args[1], DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate toDate = LocalDate.parse(args[2], DateTimeFormatter.ISO_LOCAL_DATE);
                Room room = FindRoom.findRoom(beds, fromDate, toDate);
                if (room != null) {
                    System.out.println("Found room: " + room.toString());
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                System.out.println("Invalid input format. Please use: findroom <beds> <fromDate> <toDate>");
            }
        } else {
            System.out.println("Insufficient parameters. Please use: findroom <beds> <fromDate> <toDate>");
        }
    }
}
