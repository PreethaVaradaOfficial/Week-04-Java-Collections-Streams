import java.util.regex.*;

public class UsernameValidator {
    public static void main(String[] args) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        String[] usernames = {"user_123", "123user", "us"};

        for (String username : usernames) {
            System.out.println(username + " → " + username.matches(regex));
        }
    }
}