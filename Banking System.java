public class BankingSystem {
    Map<Integer, Double> accounts = new HashMap<>();
    TreeMap<Double, List<Integer>> sortedByBalance = new TreeMap<>();
    Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedByBalance.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void requestWithdrawal(int accountNumber) {
        withdrawalQueue.offer(accountNumber);
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int acc = withdrawalQueue.poll();
            if (accounts.containsKey(acc)) {
                System.out.println("Processing withdrawal for account: " + acc);
                // You can add balance checks and deduction logic here
            }
        }
    }

    public void displaySortedAccounts() {
        System.out.println("Accounts by Balance (TreeMap): " + sortedByBalance);
    }
}