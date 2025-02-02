package hotel_rooms;

import enums.RoomType;

public abstract class Room {
    private int roomNumber;
    private int roomCapacity;
    private boolean isAvailable;
    private String note;
    private RoomType roomType;

    public Room(int roomNumber, int roomCapacity, boolean isAvailable, String note, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.isAvailable = isAvailable;
        this.note = note;
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getNote() {
        return note;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomCapacity=" + roomCapacity +
                ", isAvailable=" + isAvailable +
                ", note='" + note + '\'' +
                ", roomType=" + roomType +
                '}';
    }

    public abstract String toXML();
}
