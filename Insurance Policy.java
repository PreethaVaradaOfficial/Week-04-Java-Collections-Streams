import java.time.LocalDate;
import java.util.Objects;

public class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Name='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Coverage='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}
import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    Map<String, Integer> duplicateCount = new HashMap<>();

    public void addPolicy(Policy policy) {
        if (!hashSet.add(policy)) {
            duplicateCount.put(policy.getPolicyNumber(), duplicateCount.getOrDefault(policy.getPolicyNumber(), 1) + 1);
        }
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllUniquePolicies() {
        System.out.println("All Unique Policies (HashSet):");
        hashSet.forEach(System.out::println);
    }

    public void displayPoliciesExpiringSoon() {
        System.out.println("\nPolicies Expiring in 30 Days:");
        LocalDate today = LocalDate.now();
        LocalDate soon = today.plusDays(30);
        treeSet.stream()
                .filter(p -> !p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(soon))
                .forEach(System.out::println);
    }

    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        hashSet.stream()
                .filter(p -> p.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    public void displayDuplicatePolicies() {
        System.out.println("\nDuplicate Policy Numbers:");
        duplicateCount.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println("Policy Number: " + e.getKey() + ", Count: " + e.getValue()));
    }

    public void comparePerformance() {
        int size = 10000;
        List<Policy> policies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            policies.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Auto", 500 + i));
        }

        measurePerformance("HashSet", new HashSet<>(), policies);
        measurePerformance("LinkedHashSet", new LinkedHashSet<>(), policies);
        measurePerformance("TreeSet", new TreeSet<>(), policies);
    }

    private void measurePerformance(String name, Set<Policy> set, List<Policy> policies) {
        long startAdd = System.nanoTime();
        set.addAll(policies);
        long endAdd = System.nanoTime();

        long startSearch = System.nanoTime();
        set.contains(policies.get(policies.size() / 2));
        long endSearch = System.nanoTime();

        long startRemove = System.nanoTime();
        set.remove(policies.get(policies.size() / 2));
        long endRemove = System.nanoTime();

        System.out.printf("\nPerformance (%s):\n", name);
        System.out.printf("Add Time: %.2f ms\n", (endAdd - startAdd) / 1e6);
        System.out.printf("Search Time: %.2f µs\n", (endSearch - startSearch) / 1e3);
        System.out.printf("Remove Time: %.2f µs\n", (endRemove - startRemove) / 1e3);
    }
}
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 1500));
        manager.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 2000));
        manager.addPolicy(new Policy("P103", "Charlie", LocalDate.now().plusDays(25), "Home", 1800));
        manager.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 1500)); // Duplicate

        manager.displayAllUniquePolicies();
        manager.displayPoliciesExpiringSoon();
        manager.displayPoliciesByCoverage("Health");
        manager.displayDuplicatePolicies();
        manager.comparePerformance();
    }
}