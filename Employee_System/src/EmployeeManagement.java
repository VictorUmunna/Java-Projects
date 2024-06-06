import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeManagement {

    public static void main(String[] args) {
        // Sample dataset
        List<Employee> employees = Arrays.asList(
            new Employee("John Doe", 35, "HR", 50000),
            new Employee("Jane Smith", 28, "Finance", 60000),
            new Employee("Emily Davis", 40, "IT", 75000),
            new Employee("Michael Brown", 32, "IT", 80000)
        );

        // Function to concatenate name and department
        Function<Employee, String> nameDeptConcat = emp -> emp.getName() + " - " + emp.getDepartment();

        // Generate new collection with concatenated strings
        List<String> nameDeptList = employees.stream()
                                             .map(nameDeptConcat)
                                             .collect(Collectors.toList());

        // Print the concatenated strings
        nameDeptList.forEach(System.out::println);

        // Calculate average salary
        double averageSalary = employees.stream()
                                        .mapToDouble(Employee::getSalary)
                                        .average()
                                        .orElse(0);

        System.out.println("Average Salary: " + averageSalary);

        // Filter employees by age and print the result
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream()
                                                    .filter(emp -> emp.getAge() > ageThreshold)
                                                    .collect(Collectors.toList());

        System.out.println("Employees older than " + ageThreshold + ":");
        filteredEmployees.forEach(emp -> System.out.println(emp.getName() + ", Age: " + emp.getAge()));
    }
}
