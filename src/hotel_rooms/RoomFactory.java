package hotel_rooms;

import enums.RoomType;

// Фабрика для создания объектов hotel_rooms.Room
public class RoomFactory {
    public static Room createRoom(RoomType roomType, int roomNumber, boolean isAvailable, String note) {
        switch (roomType) {
            case SINGLE:
                return new SingleRoom(roomNumber, isAvailable, note);
            case DOUBLE:
                return new DoubleRoom(roomNumber, isAvailable, note);
            case TRIPLE:
                return new TripleRoom(roomNumber, isAvailable, note);
            case LUXURY:
                return new LuxuryRoom(roomNumber, isAvailable, note);
            default:
                throw new IllegalArgumentException("Unknown room type: " + roomType);
        }
    }
}
