import java.util.ArrayList;

public class Student extends Person {
    private String studentId;
    private ArrayList<Double> grades;

    public Student(String name, String personId, String studentId) {
        super(name, personId);
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    public String getStudentId() {return studentId;}

    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Invalid grade. Must be between 0 and 100.");
        }
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }
}
