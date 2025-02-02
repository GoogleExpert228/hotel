import FileSystem.factories.*;
import addtional_commands.factories.*;
import addtional_commands.logic.unavailables.UnavailableRoom;
import addtional_commands.logic.unavailables.UnavailableRoomService;
import contracts.Command;
import contracts.CommandFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, CommandFactory> commandFactories = new HashMap<>();
        commandFactories.put("open", new OpenFileCommandFactory());
        commandFactories.put("close", new CloseFileCommandFactory());
        commandFactories.put("add", new AddToFileCommandFactory());
        commandFactories.put("save", new SaveFileCommandFactory());
        commandFactories.put("saveas", new SaveAsFileCommandFactory());
        commandFactories.put("checkin", new CheckInCommandFactory());
        commandFactories.put("checkout", new CheckOutCommandFactory());
        commandFactories.put("availability", new AvailabilityCommandFactory());
        commandFactories.put("unavailable", new UnavailableCommandFactory());
        commandFactories.put("report", new ReportCommandFactory());
        commandFactories.put("find", new FindRoomCommandFactory());
        commandFactories.put("exit", new ExitCommandFactory());
        commandFactories.put("help", new HelpCommandFactory());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            String[] commandParts = input.split("\\s+");
            if (commandParts.length == 0) {
                System.out.println("Invalid command. Please try again.");
                continue;
            }

            String commandType = commandParts[0].toLowerCase();
            String[] args1 = new String[commandParts.length - 1];
            System.arraycopy(commandParts, 1, args1, 0, args1.length);

            CommandFactory factory = commandFactories.get(commandType);

            if (factory == null) {
                System.out.println("Unknown command. Please try again.");
                continue;
            }

            Command command = factory.createCommand(args1);

            if (command != null) {
                try {
                    command.execute(args1);
                } catch (RuntimeException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
        }
    }
}



