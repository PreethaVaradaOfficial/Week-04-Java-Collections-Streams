import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        String[] ips = {"192.168.1.1", "999.999.999.999"};

        for (String ip : ips) {
            System.out.println(ip + " → " + ip.matches(regex));
        }
    }
}