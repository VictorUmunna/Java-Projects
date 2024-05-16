import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class course_student_system {

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

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        while (option != 6) {
            System.out.print("Enter option: ");
            option = Integer.parseInt(reader.readLine());

            switch (option) {
                case 1:
                    addNewCourse(reader, courses);
                    break;
                case 2:
                    enrollNewStudent(reader, students, courses);
                    break;
                case 3:
                    addCourseToStudent(reader, students, courses);
                    break;
                case 4:
                    assignGradeToStudent(reader, students, courses);
                    break;
                case 5:
                    calculateOverallGrade(reader, students);
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

    private static void addNewCourse(BufferedReader reader, List<Course> courses) throws IOException {
        System.out.print("Enter course name: ");
        String name = reader.readLine();
        System.out.print("Enter course code: ");
        String code = reader.readLine();
        System.out.print("Enter course max capacity: ");
        int maxCapacity = Integer.parseInt(reader.readLine());
        Course course = new Course(name, code, maxCapacity);
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    private static void enrollNewStudent(BufferedReader reader, List<Student> students, List<Course> courses) throws IOException {
        System.out.print("Enter student name: ");
        String studentName = reader.readLine();
        System.out.print("Enter student id (without spaces): "); // Emphasize trimming whitespace
        String studentId = reader.readLine().trim();
        Student student = new Student(studentName, studentId);
        System.out.print("Enter course code: ");
        String courseCode = reader.readLine();
        Course course = getCourseByCode(courseCode, courses);
        if (course != null) {
            if (CourseManagement.enrollStudent(student, course, students))
                System.out.println("Student enrolled successfully.");
            else
                System.out.println("Student could not be enrolled, course is full.");
        } else {
            System.out.println("Course not found.");
        }
    }
    
    private static void addCourseToStudent(BufferedReader reader, List<Student> students, List<Course> courses) throws IOException {
        System.out.print("Enter student id (without spaces): "); // Emphasize trimming whitespace
        String studentId = reader.readLine().trim();
        Student student = getStudentById(studentId, students);
        if (student == null) {
            System.out.println("Student not found.");
            return; // Exit the method if student is not found
        }
        System.out.print("Enter course code: ");
        String courseCode = reader.readLine();
        Course course = getCourseByCode(courseCode, courses);
        if (course != null) {
            if (CourseManagement.enrollStudent(student, course, students))
                System.out.println("Course added to student successfully.");
            else
                System.out.println("Course could not be added, course is full.");
        } else {
            System.out.println("Course not found.");
        }
    }
    private static void assignGradeToStudent(BufferedReader reader, List<Student> students, List<Course> courses) throws IOException {
        System.out.print("Enter student id (without spaces): ");
        String studentId = reader.readLine().trim();
        Student student = getStudentById(studentId, students);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.print("Enter course code: ");
            String courseCode = reader.readLine();
            Course course = getCourseByCode(courseCode, courses);
            if (course != null) {
                System.out.print("Enter grade: ");
                int grade = Integer.parseInt(reader.readLine());
                student.assignGrade(course, grade);
                System.out.println("Grade assigned successfully.");
            } else {
                System.out.println("Course not found.");
            }
        }
    }

    private static void calculateOverallGrade(BufferedReader reader, List<Student> students) throws IOException {
        System.out.print("Enter student id (without spaces): ");
        String studentId = reader.readLine().trim();
        Student student = getStudentById(studentId, students);
        if (student != null) {
            System.out.println("Overall grade: " + student.calculateOverallGrade());
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Course getCourseByCode(String courseCode, List<Course> courses) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
    
    private static Student getStudentById(String studentId, List<Student> students) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}

class Student {
    private String name;
    private String id;
    private final List<Course> courses = new ArrayList<>();
    private final Map<Course, Integer> grades = new HashMap<>();

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
    }

    public void assignGrade(Course course, int grade) {
        grades.put(course, grade);
    }

    public int calculateOverallGrade() {
        int total = 0;
        for (Integer grade : grades.values()) {
            total += grade;
        }
        return grades.isEmpty() ? 0 : total / grades.size();
    }

    public List<Course> getEnrolledCourses() {
        return courses;
    }

    public int getGradeForCourse(Course course) {
        return grades.getOrDefault(course, -1);
    }
}

class Course {
    private String name;
    private String code;
    private int maxCapacity;

    public Course(String name, String code, int maxCapacity) {
        this.name = name;
        this.code = code;
        this.maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}

class CourseManagement {

    public static boolean enrollStudent(Student student, Course course, List<Student> students) {
        int totalEnrolled = 0;
        for (Student s : students) {
            if (s.getEnrolledCourses().contains(course)) {
                totalEnrolled++;
            }
        }
        if (totalEnrolled < course.getMaxCapacity()) {
            student.enrollCourse(course);
            if (!students.contains(student)) {
                students.add(student); // Add the student to the list only if they're not already in it
            }
            return true;
        }
        return false;
    }
}