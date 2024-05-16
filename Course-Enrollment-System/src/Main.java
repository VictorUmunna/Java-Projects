import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Administrator Interface:");
        System.out.println("1. Add new course");
        System.out.println("2. Enroll new student");
        System.out.println("3. Add course to a student");
        System.out.println("4. Assign grade");
        System.out.println("5. Calculate overall grade");
        System.out.println("6. Exit");

        int option = 0;

        while (option != 6) {
            System.out.print("Enter option: ");
            option = Integer.parseInt(reader.readLine());

            switch (option) {
                case 1:
                    addNewCourse(reader);
                    break;
                case 2:
                    enrollNewStudent(reader);
                    break;
                case 3:
                    addCourseToStudent(reader);
                    break;
                case 4:
                    assignGradeToStudent(reader);
                    break;
                case 5:
                    calculateOverallGrade(reader);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void addNewCourse(BufferedReader reader) throws IOException {
        System.out.print("Enter course name: ");
        String name = reader.readLine();
        System.out.print("Enter course code: ");
        String code = reader.readLine();
        System.out.print("Enter course max capacity: ");
        int maxCapacity = Integer.parseInt(reader.readLine());
        CourseManagement.addCourse(name, code, maxCapacity);
        System.out.println("Course added successfully.");
    }

    private static void enrollNewStudent(BufferedReader reader) throws IOException {
        System.out.print("Enter student name: ");
        String studentName = reader.readLine();
        System.out.print("Enter student id: ");
        String studentId = reader.readLine();
        Student student = new Student(studentName, studentId);
        System.out.print("Enter course code: ");
        String courseCode = reader.readLine();
        Course course = CourseManagement.getCourseByCode(courseCode);
        if (course != null) {
            if (CourseManagement.enrollStudent(student, course))
                System.out.println("Student enrolled successfully.");
            else
                System.out.println("Student could not be enrolled, course is full.");
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void addCourseToStudent(BufferedReader reader) throws IOException {
        System.out.print("Enter student id: ");
        String studentId = reader.readLine();
        Student student = CourseManagement.getStudentById(studentId);
        System.out.print("Enter course code: ");
        String courseCode = reader.readLine();
        Course course = CourseManagement.getCourseByCode(courseCode);
        if (course != null) {
            if (CourseManagement.enrollStudent(student, course))
                System.out.println("Course added to student successfully.");
            else
                System.out.println("Course could not be added, course is full.");
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void assignGradeToStudent(BufferedReader reader) throws IOException {
        System.out.print("Enter student id: ");
        String studentId = reader.readLine();
        Student student = CourseManagement.getStudentById(studentId);
        System.out.print("Enter course code: ");
        String courseCode = reader.readLine();
        Course course = CourseManagement.getCourseByCode(courseCode);
        if (course != null) {
            System.out.print("Enter grade: ");
            int grade = Integer.parseInt(reader.readLine());
            CourseManagement.assignGrade(student, course, grade);
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void calculateOverallGrade(BufferedReader reader) throws IOException {
        System.out.print("Enter student id: ");
        String studentId = reader.readLine();
        Student student = CourseManagement.getStudentById(studentId);
        if (student != null) {
            System.out.println("Overall grade: " + CourseManagement.calculateOverallGrade(student));
        } else {
            System.out.println("Student not found.");
        }
    }
}
