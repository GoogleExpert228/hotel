package addtional_commands.logic.unavailables;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UnavailableRoomService {
    private static final String UNAVAILABLE_FILE = "unavailable.xml";

    public static void makeUnavailable(UnavailableRoom room) {
        String roomXML = UnavailableRoomXMLConverter.toXML(room);
        try {
            File file = new File(UNAVAILABLE_FILE);
            StringBuilder content = UnavailableFileHandler.readFile(file);

            if (content.indexOf(roomXML) != -1) {
                System.out.println("Duplicate unavailable room. Not adding to file.");
                return;
            }

            if (!content.toString().contains("<unavailabilities>")) {
                content.insert(0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<unavailabilities>\n");
            } else {
                content = new StringBuilder(content.substring(0, content.lastIndexOf("</unavailabilities>")));
            }

            content.append(roomXML);
            content.append("</unavailabilities>");
            UnavailableFileHandler.writeFile(file, content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cancelUnavailable(int roomNumber) {
        try {
            List<UnavailableRoom> unavailableRooms = UnavailableRoomsParser.parseUnavailableRooms(UNAVAILABLE_FILE);
            UnavailableRoom roomToRemove = unavailableRooms.stream()
                    .filter(room -> room.getRoomNumber() == roomNumber)
                    .findFirst()
                    .orElse(null);

            if (roomToRemove != null) {
                unavailableRooms.remove(roomToRemove);
                writeUnavailableRoomsToXML(unavailableRooms);
                System.out.println("Room " + roomNumber + " is now available.");
            } else {
                System.out.println("No unavailable room found for room number " + roomNumber + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeUnavailableRoomsToXML(List<UnavailableRoom> rooms) {
        StringBuilder content = new StringBuilder();
        content.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        content.append("<unavailabilities>\n");
        for (UnavailableRoom room : rooms) {
            content.append(UnavailableRoomXMLConverter.toXML(room));
        }
        content.append("</unavailabilities>");

        try {
            UnavailableFileHandler.writeFile(new File(UNAVAILABLE_FILE), content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
