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
            new Employee("Victor Umunna", 26, "Data Analytics", 80000),
            new Employee("Dare Seun", 28, "HR", 50000),
            new Employee("Ada Nnokwe", 33, "IT", 95000),
            new Employee("Boma Akpofure", 30, "Facility", 80000)
        );

        // Function to concatenate name and department
        Function<Employee, String> nameDeptConcat = emp -> emp.getName() + " - " + emp.getDepartment();

        // Generate new collection with concatenated strings
        List<String> nameDeptList = employees.stream()
                                             .map(nameDeptConcat)
                                             .collect(Collectors.toList());

        // Print the concatenated strings
        System.out.println("Concatenated Name and Department:");
        nameDeptList.forEach(System.out::println);

        System.out.println();

        // Calculate average salary
        double averageSalary = employees.stream()
                                        .mapToDouble(Employee::getSalary)
                                        .average()
                                        .orElse(0);

        System.out.println("Average Salary: " + averageSalary);

        System.out.println();

        // Filter employees by age
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream()
                                                    .filter(emp -> emp.getAge() > ageThreshold)
                                                    .collect(Collectors.toList());

        System.out.println("Employees older than " + ageThreshold + ":");
        filteredEmployees.forEach(emp -> System.out.println(emp.getName() + ", Age: " + emp.getAge()));

        System.out.println();

        // Additional Feature: Sort employees by salary
        System.out.println("Employees sorted by salary (ascending):");
        List<Employee> sortedBySalaryAsc = employees.stream()
                                                    .sorted(Comparator.comparingDouble(Employee::getSalary))
                                                    .collect(Collectors.toList());
        sortedBySalaryAsc.forEach(emp -> System.out.println(emp.getName() + ", Salary: " + emp.getSalary()));
    }
}
