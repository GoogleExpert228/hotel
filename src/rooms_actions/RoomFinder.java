package rooms_actions;

import hotel_rooms.Room;
import java.util.List;
public class RoomFinder {
    private static final String fileName = "rooms.xml";

    public static Room getRoomByNumber(int roomNumber) {
        List<Room> rooms = RoomXMLParser.parseRooms(fileName);
        for(Room room: rooms) {
            if(room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
 }
