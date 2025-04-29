import java.util.*;
class SortingPerformanceComparison{
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        mergeSortHelper(arr, 0, arr.length - 1);
    }
    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void runSortComparison(int size) {
        Random rand = new Random();
        int[] original = new int[size];

        for (int i = 0; i < size; i++) {
            original[i] = rand.nextInt(size * 10);
        }

        System.out.println("\nDataset Size: " + size);
        if (size <= 10000) {
            int[] arr1 = original.clone();
            long start = System.nanoTime();
            bubbleSort(arr1);
            long end = System.nanoTime();
            System.out.println("Bubble Sort: " + (end - start) / 1_000_000.0 + " ms");
        } else {
            System.out.println("Bubble Sort: Skipped (too slow)");
        }
        int[] arr2 = original.clone();
        long startMerge = System.nanoTime();
        mergeSort(arr2);
        long endMerge = System.nanoTime();
        System.out.println("Merge Sort: " + (endMerge - startMerge) / 1_000_000.0 + " ms");
        int[] arr3 = original.clone();
        long startQuick = System.nanoTime();
        quickSort(arr3);
        long endQuick = System.nanoTime();
        System.out.println("Quick Sort: " + (endQuick - startQuick) / 1_000_000.0 + " ms");
    }
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int size : sizes) {
            runSortComparison(size);
        }
    }
}