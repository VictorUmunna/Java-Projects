import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private final List<Course> courses = new ArrayList<>();
    private final Map<Course, Integer> grades = new HashMap<>();

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getter and setter methods for name and id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Method to enroll a student in a course
    public void enrollCourse(Course course) {
        courses.add(course);
    }

    // Method to assign a grade for a course
    public void assignGrade(Course course, int grade) {
        grades.put(course, grade);
    }

    // Method to get all enrolled courses
    public List<Course> getEnrolledCourses() {
        return courses;
    }

    // Method to get grade for a specific course
    public int getGradeForCourse(Course course) {
        return grades.getOrDefault(course, -1); // Returns -1 if the course grade is not found
    }
}
