package addtional_commands.logic.registrations;

import addtional_commands.helpfull_classes.FileHandler;
import addtional_commands.logic.unavailables.UnavailableRoom;
import addtional_commands.logic.unavailables.UnavailableRoomsParser;
import rooms_actions.RoomEditor;
import rooms_actions.RoomFinder;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class RegistrationService {
    private static final String REGISTRATIONS_FILE_PATH = "registrations.xml";
    private static final String HISTORY_FILE_PATH = "history.xml";
    private static final String UNAVAILABLE_FILE_PATH = "unavailable.xml";

    public List<Registration> loadRegistrations(String filePath) {
        return RegistrationParser.parseRegistrations(filePath);
    }

    public static void checkIn(Registration registration) {
        String reservationXML = registration.toXML();
        LocalDate registrationStartDate = registration.getCheckInDate();
        LocalDate registrationEndDate = registration.getCheckOutDate();

        try {
            List<Registration> existingRegistrations = RegistrationParser.parseRegistrations(REGISTRATIONS_FILE_PATH);
            List<UnavailableRoom> unavailableRooms = UnavailableRoomsParser.parseUnavailableRooms(UNAVAILABLE_FILE_PATH);

            // Check for duplicate registration
            boolean isDuplicate = existingRegistrations.stream().anyMatch(existingRegistration ->
                    existingRegistration.getRoomNumber() == registration.getRoomNumber() &&
                            existingRegistration.getCheckInDate().equals(registration.getCheckInDate()) &&
                            existingRegistration.getCheckOutDate().equals(registration.getCheckOutDate())
            );

            if (isDuplicate) {
                System.out.println("Duplicate registration detected. This registration will not be added.");
                return;
            }

            // Check for room availability
            boolean isRoomUnavailable = unavailableRooms.stream().anyMatch(unavailableRoom ->
                    unavailableRoom.getRoomNumber() == registration.getRoomNumber() &&
                            !(registrationEndDate.isBefore(unavailableRoom.getStartDate()) || registrationStartDate.isAfter(unavailableRoom.getEndDate()))
            );

            if (isRoomUnavailable) {
                System.out.println("The room is unavailable during the specified period. Registration will not be added.");
                return;
            }

            StringBuilder contentRegistrations = FileHandler.handleFile(new File(REGISTRATIONS_FILE_PATH), reservationXML, existingRegistrations);
            StringBuilder contentHistory = FileHandler.handleFile(new File(HISTORY_FILE_PATH), reservationXML, existingRegistrations);

            if (contentRegistrations == null || contentHistory == null) {
                return;
            }

            if (registration.getGuestsNumber() <= RoomFinder.getRoomByNumber(registration.getRoomNumber()).getRoomCapacity()) {
                FileHandler.writeToFile(new File(REGISTRATIONS_FILE_PATH), contentRegistrations);
                FileHandler.writeToFile(new File(HISTORY_FILE_PATH), contentHistory);
                System.out.println("Registration for room " + registration.getRoomNumber() + " has been checked in.");
                RoomEditor.editRoom(registration.getRoomNumber(), false);
            } else {
                System.out.println("The capacity of the room is less than the number of settled persons.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkOut(int roomNumber) {
        try {
            List<Registration> registrations = RegistrationParser.parseRegistrations(REGISTRATIONS_FILE_PATH);
            Registration registrationToRemove = registrations.stream()
                    .filter(registration -> registration.getRoomNumber() == roomNumber)
                    .findFirst().orElse(null);

            if (registrationToRemove != null) {
                registrations.remove(registrationToRemove);
                FileHandler.writeRegistrationsToXML(registrations, new File(REGISTRATIONS_FILE_PATH));
                System.out.println("Registration for room " + roomNumber + " has been checked out.");
                RoomEditor.editRoom(roomNumber, true);
            } else {
                System.out.println("No registration found for room " + roomNumber + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
