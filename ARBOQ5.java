class FibonacciComparison {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        int[] testCases = {10, 30, 50};
        for (int n : testCases) {
            System.out.println("\nFibonacci(" + n + ")");
            long startIter = System.nanoTime();
            int resultIter = fibonacciIterative(n);
            long endIter = System.nanoTime();
            System.out.println("Iterative Result: " + resultIter + ", Time: " + (endIter - startIter) / 1_000_000.0 + " ms");
            if (n <= 30) {
                long startRec = System.nanoTime();
                int resultRec = fibonacciRecursive(n);
                long endRec = System.nanoTime();
                System.out.println("Recursive Result: " + resultRec + ", Time: " + (endRec - startRec) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Recursive: Skipped (too slow for N > 30)");
            }
        }
    }
}