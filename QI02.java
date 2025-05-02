import java.util.*;

public class BinaryGenerator {
    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        while (n-- > 0) {
            String current = queue.poll();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateBinary(5));  // Output: [1, 10, 11, 100, 101]
    }
}

