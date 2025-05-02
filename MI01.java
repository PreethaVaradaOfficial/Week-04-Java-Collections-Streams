import java.util.*;
import java.util.regex.*;

public class WordFrequency {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> map = new HashMap<>();
        String cleaned = text.toLowerCase().replaceAll("[^a-z\\s]", "");
        for (String word : cleaned.split("\\s+")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        System.out.println(countWords(input));}
    }
}