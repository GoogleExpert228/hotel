package addtional_commands.logic.unavailables;

import java.time.LocalDate;

public class UnavailableRoom {
    private int roomNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private String note;

    public UnavailableRoom(int roomNumber, LocalDate startDate, LocalDate endDate, String note) {
        this.roomNumber = roomNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getNote() {
        return note;
    }
}
