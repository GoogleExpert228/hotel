package addtional_commands.logic.unavailables;

class UnavailableRoomXMLConverter {

    public static String toXML(UnavailableRoom room) {
        return String.format(
                "<unavailable>\n" +
                        "   <number>%s</number>\n" +
                        "   <startDate>%s</startDate>\n" +
                        "   <endDate>%s</endDate>\n" +
                        "   <note>%s</note>\n" +
                        "</unavailable>\n\n",
                room.getRoomNumber(), room.getStartDate(), room.getEndDate(), room.getNote());
    }
}
