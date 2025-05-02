import java.util.*;

class Employee {
    String name, department;
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee emp : employees) {
            grouped.putIfAbsent(emp.department, new ArrayList<>());
            grouped.get(emp.department).add(emp);
        }
        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        grouped.forEach((dept, emps) -> System.out.println(dept + ": " + emps));
          }
}
