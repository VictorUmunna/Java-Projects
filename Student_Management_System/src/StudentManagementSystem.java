
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentManagementSystem extends Application {
    private ObservableList<Student> students = FXCollections.observableArrayList();
    private TableView<Student> studentTableView = new TableView<>();
    private ComboBox<String> courseComboBox = new ComboBox<>();
    private ComboBox<Student> studentComboBox = new ComboBox<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Management System");

        TabPane tabPane = new TabPane();

        Tab studentManagementTab = new Tab("Student Management", createStudentManagementPane());
        Tab courseEnrollmentTab = new Tab("Course Enrollment", createCourseEnrollmentPane());
        Tab gradeManagementTab = new Tab("Grade Management", createGradeManagementPane());

        tabPane.getTabs().addAll(studentManagementTab, courseEnrollmentTab, gradeManagementTab);

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @SuppressWarnings("unchecked")
    private VBox createStudentManagementPane() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        GridPane formPane = new GridPane();
        formPane.setHgap(10);
        formPane.setVgap(10);
        formPane.setPadding(new Insets(10));

        TextField nameField = new TextField();
        TextField ageField = new TextField();
        TextField emailField = new TextField();
        Button addButton = new Button("Add Student");
        Button updateButton = new Button("Update Student");

        formPane.add(new Label("Name:"), 0, 0);
        formPane.add(nameField, 1, 0);
        formPane.add(new Label("Age:"), 0, 1);
        formPane.add(ageField, 1, 1);
        formPane.add(new Label("Email:"), 0, 2);
        formPane.add(emailField, 1, 2);
        formPane.add(addButton, 0, 3);
        formPane.add(updateButton, 1, 3);

        studentTableView.setItems(students);
        studentTableView.getColumns().addAll(
            createColumn("Name", "name"),
            createColumn("Age", "age"),
            createColumn("Email", "email")
        );

        addButton.setOnAction(e -> {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String email = emailField.getText();
            students.add(new Student(name, age, email));
        });

        updateButton.setOnAction(e -> {
            Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                selectedStudent.setName(nameField.getText());
                selectedStudent.setAge(Integer.parseInt(ageField.getText()));
                selectedStudent.setEmail(emailField.getText());
                studentTableView.refresh();
            }
        });

        vbox.getChildren().addAll(formPane, new Label("Students:"), studentTableView);
        return vbox;
    }

    private VBox createCourseEnrollmentPane() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        courseComboBox.setItems(FXCollections.observableArrayList("Math", "Science", "History"));
        studentComboBox.setItems(students);
        Button enrollButton = new Button("Enroll Student");

        enrollButton.setOnAction(e -> {
            String selectedCourse = courseComboBox.getValue();
            Student selectedStudent = studentComboBox.getValue();
            if (selectedCourse != null && selectedStudent != null) {
                selectedStudent.enrollCourse(selectedCourse);
            }
        });

        vbox.getChildren().addAll(new Label("Select Course:"), courseComboBox,
            new Label("Select Student:"), studentComboBox, enrollButton);
        return vbox;
    }

    private VBox createGradeManagementPane() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        ComboBox<Student> studentGradeComboBox = new ComboBox<>(students);
        ComboBox<String> courseGradeComboBox = new ComboBox<>(FXCollections.observableArrayList("Math", "Science", "History"));
        TextField gradeField = new TextField();
        Button assignGradeButton = new Button("Assign Grade");

        assignGradeButton.setOnAction(e -> {
            Student selectedStudent = studentGradeComboBox.getValue();
            String selectedCourse = courseGradeComboBox.getValue();
            String grade = gradeField.getText();
            if (selectedStudent != null && selectedCourse != null && !grade.isEmpty()) {
                selectedStudent.assignGrade(selectedCourse, grade);
            }
        });

        vbox.getChildren().addAll(new Label("Select Student:"), studentGradeComboBox,
            new Label("Select Course:"), courseGradeComboBox, new Label("Grade:"), gradeField, assignGradeButton);
        return vbox;
    }

    private TableColumn<Student, String> createColumn(String title, String property) {
        TableColumn<Student, String> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        return column;
    }

    public static class Student {
        private String name;
        private int age;
        private String email;
        private ObservableList<String> courses = FXCollections.observableArrayList();
        private ObservableMap<String, String> grades = FXCollections.observableHashMap();

        public Student(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public void enrollCourse(String course) {
            courses.add(course);
        }

        public void assignGrade(String course, String grade) {
            grades.put(course, grade);
        }
    }
}
