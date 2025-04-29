import java.util.*;

class SearchPerformanceComparison {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static void runComparison(int size, int target) {
        Random rand = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size * 10);
        }
        long startLinear = System.nanoTime();
        int resultLinear = linearSearch(data, target);
        long endLinear = System.nanoTime();
        int[] sortedData = data.clone();
        Arrays.sort(sortedData);
        long startBinary = System.nanoTime();
        int resultBinary = binarySearch(sortedData, target);
        long endBinary = System.nanoTime();
        System.out.println("Dataset Size: " + size);
        System.out.println("Linear Search: " + (endLinear - startLinear) / 1_000_000.0 + " ms (Result: " + resultLinear + ")");
        System.out.println("Binary Search: " + (endBinary - startBinary) / 1_000_000.0 + " ms (Result: " + resultBinary + ")");
        System.out.println("---------------------------------------------------");
    }
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        int target = 42;
        for (int size : sizes) {
            runComparison(size, target);
        }
    }
}
