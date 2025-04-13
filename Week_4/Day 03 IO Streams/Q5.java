import java.io.*;
import java.nio.file.*;

public class ImageByteArray {
    public static void main(String[] args) throws IOException {
        byte[] data = Files.readAllBytes(Paths.get("original.jpg"));

        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            int byteData;
            while ((byteData = bais.read()) != -1) {
                baos.write(byteData);
            }

            byte[] newImage = baos.toByteArray();
            Files.write(Paths.get("copy.jpg"), newImage);
        }
    }
}