package rooms_actions;

import hotel_rooms.Room;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// Класс для редактирования комнат
public class RoomEditor {
    private static final String fileName = "rooms.xml";

    public static void editRoom(int roomNumber, String newNote) {
        editRoomAttribute(roomNumber, "note", newNote);
    }

    public static void editRoom(int roomNumber, boolean isAvailable) {
        editRoomAttribute(roomNumber, "available", String.valueOf(isAvailable));
    }

    private static void editRoomAttribute(int roomNumber, String attribute, String newValue) {
        try {
            Path path = Paths.get(fileName);
            List<String> lines = Files.readAllLines(path);
            for (int i = 0; i < lines.size() - 1; i++) {
                String line = lines.get(i);
                if (line.contains("<number>" + roomNumber + "</number>")) {
                    if (attribute.equals("available")) {
                        lines.set(i + 3, "   <available>" + newValue + "</available>");
                    } else if (attribute.equals("note")) {
                        lines.set(i + 4, "   <note>" + newValue + "</note>");
                    }
                    break;
                }
            }
            Files.write(path, lines);
        } catch (IOException e) {
            System.out.println("An error occurred while editing room " + roomNumber + ": " + e.getMessage());
        }
    }
}
