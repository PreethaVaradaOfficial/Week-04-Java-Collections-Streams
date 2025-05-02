import java.util.*;
class DataStructureSearchComparison {
    public static void main(String[] args) {
        final int N = 1_000_000;
        int target = N - 1;
        List<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
            hashSet.add(i);
            treeSet.add(i);
        }
        System.out.println("Search for target: " + target);
        long startArray = System.nanoTime();
        boolean foundInArray = arrayList.contains(target);
        long endArray = System.nanoTime();
        System.out.println("ArrayList: Found = " + foundInArray + ", Time = " + (endArray - startArray) / 1_000_000.0 + " ms");
        long startHash = System.nanoTime();
        boolean foundInHash = hashSet.contains(target);
        long endHash = System.nanoTime();
        System.out.println("HashSet: Found = " + foundInHash + ", Time = " + (endHash - startHash) / 1_000_000.0 + " ms");
        long startTree = System.nanoTime();
        boolean foundInTree = treeSet.contains(target);
        long endTree = System.nanoTime();
        System.out.println("TreeSet: Found = " + foundInTree + ", Time = " + (endTree - startTree) / 1_000_000.0 + " ms");
    }
}