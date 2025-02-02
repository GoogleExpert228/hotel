package hotel_rooms;

import enums.RoomType;

public class TripleRoom extends Room {
    public TripleRoom(int roomNumber, boolean isAvailable, String note) {
        super(roomNumber, 3, isAvailable, note, RoomType.TRIPLE);
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
