import java.util.*;

public class SymmetricDiff {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        for (T item : set2) {
            if (!result.add(item)) {
                result.remove(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println(symmetricDifference(set1, set2));     }
}