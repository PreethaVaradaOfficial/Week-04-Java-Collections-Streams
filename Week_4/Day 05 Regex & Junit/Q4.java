import java.util.regex.*;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        String regex = "\\b[\\w.%-]+@[\\w.-]+\\.[a-zA-Z]{2,}\\b";
        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}