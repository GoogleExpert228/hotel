package addtional_commands.logic.registrations;

import java.time.LocalDate;

public class Registration {
    private int roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String note;
    private int guestsNumber;

    public Registration(int roomNumber, LocalDate checkInDate, LocalDate checkOutDate, String note, int guestsNumber) {
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.note = note;
        this.guestsNumber = guestsNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public String getNote() {
        return note;
    }

    public int getGuestsNumber() {
        return guestsNumber;
    }

    public String toXML() {
        return String.format(
                "<registration>\n" +
                        "   <number>%s</number>\n" +
                        "   <checkInDate>%s</checkInDate>\n" +
                        "   <checkOutDate>%s</checkOutDate>\n" +
                        "   <note>%s</note>\n" +
                        "   <guestsNumber>%s</guestsNumber>\n" +
                        "</registration>\n\n",
                roomNumber, checkInDate, checkOutDate, note, guestsNumber);
    }
}
