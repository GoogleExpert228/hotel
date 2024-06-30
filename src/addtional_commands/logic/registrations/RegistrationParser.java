package addtional_commands.logic.registrations;

import addtional_commands.helpfull_classes.XMLUtils;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistrationParser {
    public static List<Registration> parseRegistrations(String filePath) {
        List<Registration> registrations = new ArrayList<>();
        try {
            File xmlFile = new File(filePath);
            FileInputStream fis = new FileInputStream(xmlFile);

            StringBuilder xmlStringBuilder = new StringBuilder();
            int ch;
            while ((ch = fis.read()) != -1) {
                xmlStringBuilder.append((char) ch);
            }

            String xmlString = xmlStringBuilder.toString();
            int registrationStartIndex = xmlString.indexOf("<registration>");
            while (registrationStartIndex != -1) {
                int registrationEndIndex = xmlString.indexOf("</registration>", registrationStartIndex);
                String registrationXml = xmlString.substring(registrationStartIndex, registrationEndIndex + 15);

                int roomNumber = Integer.parseInt(XMLUtils.getValueFromTag(registrationXml, "number"));
                LocalDate checkInDate = LocalDate.parse(XMLUtils.getValueFromTag(registrationXml, "checkInDate"), DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate checkOutDate = LocalDate.parse(XMLUtils.getValueFromTag(registrationXml, "checkOutDate"), DateTimeFormatter.ISO_LOCAL_DATE);
                String note = XMLUtils.getValueFromTag(registrationXml, "note");
                int guestsNumber = Integer.parseInt(XMLUtils.getValueFromTag(registrationXml, "guestsNumber"));

                registrations.add(new Registration(roomNumber, checkInDate, checkOutDate, note, guestsNumber));
                registrationStartIndex = xmlString.indexOf("<registration>", registrationEndIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registrations;
    }
}
