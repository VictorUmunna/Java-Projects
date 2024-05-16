import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseManagement {

    private CourseManagement() {
        throw new IllegalStateException("Utility class");
    }

    private static final List<Course> courses = new ArrayList<>();
    private static final List<Student> students = new ArrayList<>();

    public static void addCourse(String name, String code, int maxCapacity) {
        Course course = new Course(name, code, maxCapacity);
        courses.add(course);
    }

    public static boolean enrollStudent(Student student, Course course) {
        if (course.getMaxCapacity() > Course.getTotalEnrolled()) {
            student.enrollCourse(course);
            students.add(student);
            Course.incrementTotalEnrolled();
            return true;
        }
        return false;
    }

    public static void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
    }

    public static Course getCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public static Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public static int calculateOverallGrade(Student student) {
        int total = 0;
        for (Course course : student.getEnrolledCourses()) {
            total += student.getGradeForCourse(course);
        }
        return student.getEnrolledCourses().isEmpty() ? 0 : total / student.getEnrolledCourses().size();
    }

    public static List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public static List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}
