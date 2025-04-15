import java.util.regex.*;

public class HexColorValidator {
    public static void main(String[] args) {
        String regex = "^#[0-9a-fA-F]{6}$";
        String[] colors = {"#FFA500", "#ff4500", "#123"};

        for (String color : colors) {
            System.out.println(color + " → " + color.matches(regex));
        }
    }
}