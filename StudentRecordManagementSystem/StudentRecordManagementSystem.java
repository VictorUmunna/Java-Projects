import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private int age;
    private double grade;

    public Student(String name, int id, int age, double grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }
}

class StudentRecordManagementSystem {
    private static int totalStudents = 0;
    private static Student[] studentList = new Student[100];
    private static Scanner scanner = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        Student newStudent = new Student(name, id, age, grade);
        studentList[totalStudents++] = newStudent;
        System.out.println("Student added successfully.");
    }

    public static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int updateId = scanner.nextInt();
        System.out.print("Enter new age: ");
        int newAge = scanner.nextInt();
        System.out.print("Enter new grade: ");
        double newGrade = scanner.nextDouble();
        try {
            boolean found = false;
            for (int i = 0; i < totalStudents; i++) {
                if (studentList[i].getId() == updateId) {
                    studentList[i] = new Student(studentList[i].getName(), updateId, newAge, newGrade);
                    System.out.println("Student information updated successfully.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Student ID not found.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewStudentDetails() {
        System.out.print("Enter student ID to view details: ");
        int viewId = scanner.nextInt();
        try {
            boolean found = false;
            for (int i = 0; i < totalStudents; i++) {
                if (studentList[i].getId() == viewId) {
                    System.out.println("Name: " + studentList[i].getName());
                    System.out.println("ID: " + studentList[i].getId());
                    System.out.println("Age: " + studentList[i].getAge());
                    System.out.println("Grade: " + studentList[i].getGrade());
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Student ID not found.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add new student");
            System.out.println("2. Update student information");
            System.out.println("3. View student details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    viewStudentDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
}
