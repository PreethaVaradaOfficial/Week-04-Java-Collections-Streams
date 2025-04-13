
import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) throws IOException {
        File source = new File("largefile.dat");
        File dest = new File("copy.dat");

        long start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
        long end = System.nanoTime();
        System.out.println("Buffered copy time (ns): " + (end - start));
    }
}

