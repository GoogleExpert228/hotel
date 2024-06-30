package addtional_commands.logic.unavailables;

import java.io.*;

class UnavailableFileHandler {

    public static StringBuilder readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        }
        return content;
    }

    public static void writeFile(File file, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.close();
    }
}
