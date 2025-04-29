import java.io.*;
class FileReadPerformance {
    public static void main(String[] args) {
        String filePath = "largefile.txt";
        System.out.println("Benchmarking file reading performance for file: " + filePath);
        long startFileReader = System.currentTimeMillis();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fileReader)) {
            while (br.readLine() != null) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endFileReader = System.currentTimeMillis();
        System.out.println("FileReader time: " + (endFileReader - startFileReader) + " ms");
        long startInputStream = System.currentTimeMillis();
        try (InputStream inputStream = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            while (br.readLine() != null) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endInputStream = System.currentTimeMillis();
        System.out.println("InputStreamReader time: " + (endInputStream - startInputStream) + " ms");
    }
}