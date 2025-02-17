import java.util.ArrayList;

public class GradeManager {
    private ArrayList<Student> students;

    public GradeManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Empty records.");
            return;
        }
        for (Student student : students) {
            System.out.println("Name: " + student.getName() +
                    ", ID: " + student.getStudentId() +
                    ", Average: " + student.calculateAverage());
        }
    }
}
