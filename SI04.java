import java.util.*;

public class SortSet {
    public static List<Integer> sortSet(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println(sortSet(set));  // Output: [1, 3, 5, 9]
    }
}
