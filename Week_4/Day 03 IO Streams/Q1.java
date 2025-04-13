
import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        File source = new File("source.txt");
        File dest = new File("destination.txt");

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            System.out.println("File operation failed: " + e.getMessage());
        }
    }
}

