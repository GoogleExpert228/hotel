package addtional_commands.helpfull_classes;

public class XMLUtils {
    public static String getValueFromTag(String xml, String tag) {
        int startIndex = xml.indexOf("<" + tag + ">") + tag.length() + 2;
        int endIndex = xml.indexOf("</" + tag + ">", startIndex);
        return xml.substring(startIndex, endIndex);
    }
}
