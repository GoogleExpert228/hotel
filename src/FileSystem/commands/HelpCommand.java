package FileSystem.commands;

import contracts.Command;

public class HelpCommand implements Command {
    @Override
    public void execute(String... args) {
        System.out.println("\nThe following commands are supported:\n"
                + " open <file> - opens <file>\n"
                + " close - closes currently opened file\n"
                + " save - saves the currently open file\n"
                + " saveas <file> - saves the currently open file in <file>\n"
                + " checkin <room> <from> <to> <note> [<guests>] - register in a room\n"
                + " availability [<date>] - shows available rooms on <date>\n"
                + " checkout <room> - checks out from a room\n"
                + " report <from> <to> - reports room usage between <from> and <to>\n"
                + " find <beds> <from> <to> - finds a room with <beds> between <from> and <to>\n"
                + " unavailable <room> <from> <to> <note> - marks a room as unavailable\n"
                + " help - prints this information\n"
                + " exit - exits the program\n");
    }
}
