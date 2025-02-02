package hotel_rooms;

import enums.RoomType;

// Классы конкретных типов комнат
public class SingleRoom extends Room {
    public SingleRoom(int roomNumber, boolean isAvailable, String note) {
        super(roomNumber, 1, isAvailable, note, RoomType.SINGLE);
    }

    @Override
    public String toXML() {
        return String.format(
                "<room>\n" +
                        "   <number>%d</number>\n" +
                        "   <type>%s</type>\n" +
                        "   <capacity>%d</capacity>\n" +
                        "   <available>%b</available>\n" +
                        "   <note>%s</note>\n" +
                        "</room>\n",
                getRoomNumber(), getRoomType(), getRoomCapacity(), isAvailable(), getNote());
    }
}
