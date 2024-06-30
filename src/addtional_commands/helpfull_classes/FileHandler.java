package addtional_commands.helpfull_classes;

import addtional_commands.logic.registrations.Registration;

import java.io.*;
import java.util.List;

public class FileHandler {
    public static StringBuilder handleFile(File file, String reservationXML, List<Registration> existingRegistrations) throws IOException {
        StringBuilder content = new StringBuilder();
        boolean isFileNew = !file.exists();

        if (!isFileNew) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            boolean insideRootElement = false;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
                if (line.trim().equals("<registrations>")) {
                    insideRootElement = true;
                }
            }
            reader.close();

            if (!insideRootElement) {
                System.err.println("Error: The XML file is corrupted.");
                return null;
            }

            int lastIndex = content.lastIndexOf("</registrations>");
            if (lastIndex != -1) {
                content.delete(lastIndex, content.length());
            }
        } else {
            content.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            content.append("<registrations>\n");
        }

        content.append(reservationXML);
        content.append("</registrations>");
        return content;
    }

    public static void writeToFile(File file, StringBuilder content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content.toString());
        writer.close();
    }

    public static void writeRegistrationsToXML(List<Registration> registrations, File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<registrations>\n");
            for (Registration registration : registrations) {
                writer.write(registration.toXML());
            }
            writer.write("</registrations>");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
