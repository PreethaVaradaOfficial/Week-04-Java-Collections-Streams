import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> freq = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("textfile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+")) {
                    freq.put(word, freq.getOrDefault(word, 0) + 1);
                }
            }
        }

        freq.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .limit(5)
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}