import java.util.regex.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}