import java.io.*;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}