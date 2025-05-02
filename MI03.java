import java.util.*;

public class MaxValueKey {
    public static String findMaxKey(Map<String, Integer> map) {
        String maxKey = null;
        int maxVal = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> data = Map.of("A", 10, "B", 20, "C", 15);
        System.out.println("Key with max value: " + findMaxKey(data));     }
}