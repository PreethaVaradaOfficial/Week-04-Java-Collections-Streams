class StringConcatenationPerformance {
    private static final int ITERATIONS = 1_000_000;
    private static final String TEXT = "hello";
    public static void main(String[] args) {
        System.out.println("Starting string concatenation benchmark for " + ITERATIONS + " iterations...\n");
        long startString = System.currentTimeMillis();
        String resultString = "";
        for (int i = 0; i < ITERATIONS; i++) {
            resultString += TEXT;
        }
        long endString = System.currentTimeMillis();
        System.out.println("String time: " + (endString - startString) + " ms");
        long startBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(TEXT);
        }
        long endBuilder = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endBuilder - startBuilder) + " ms");
        long startBuffer = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            sbf.append(TEXT);
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endBuffer - startBuffer) + " ms");
    }
}