public class Course {
    private String name;
    private String code;
    private int maxCapacity;
    private static int totalEnrolled = 0;

    public Course(String name, String code, int maxCapacity) {
        this.name = name;
        this.code = code;
        this.maxCapacity = maxCapacity;
    }

    // Getter methods for course information
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Method to retrieve total number of enrolled students
    public static int getTotalEnrolled() {
        return totalEnrolled;
    }

    // Method to increment total number of enrolled students
    public static void incrementTotalEnrolled() {
        totalEnrolled++;
    }

    // Method to decrement total number of enrolled students
    public static void decrementTotalEnrolled() {
        totalEnrolled--;
    }
}
