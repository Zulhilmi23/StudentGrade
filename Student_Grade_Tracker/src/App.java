import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        GradeManager gradeManager = new GradeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Grade Tracker ===");
            System.out.println("1. Add a New Student");
            System.out.println("2. Enter Grades for a Student");
            System.out.println("3. View Grades for an Existing Student");
            System.out.println("4. View a Student's Report (Including Average)");
            System.out.println("5. View All Students");
            System.out.println("6. Export Data to File");
            System.out.println("7. Import Data from File");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Person ID: ");
                    String personId = scanner.nextLine();
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    gradeManager.addStudent(new Student(name, personId, studentId));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    Student student = gradeManager.getStudentById(studentId);
                    if (student != null) {
                        System.out.print("Enter Grade: ");
                        double grade = scanner.nextDouble();
                        student.addGrade(grade);
                        System.out.println("Grade added successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    student = gradeManager.getStudentById(studentId);
                    if (student != null) {
                        System.out.println("Grades: " + student.getGrades());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    student = gradeManager.getStudentById(studentId);
                    if (student != null) {
                        System.out.println("Name: " + student.getName() +
                                ", ID: " + student.getStudentId() +
                                ", Grades: " + student.getGrades() +
                                ", Average: " + student.calculateAverage());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 5:
                    gradeManager.displayAllStudents();
                    break;
                case 6:
                    System.out.print("Enter filename to export: ");
                    String exportFile = scanner.nextLine();
                    FileManager.exportDataToFile(exportFile, gradeManager.getAllStudents());
                    break;
                case 7:
                    System.out.print("Enter filename to import: ");
                    String importFile = scanner.nextLine();
                    ArrayList<Student> importedStudents = FileManager.importDataFromFile(importFile);
                    for (Student s : importedStudents) {
                        gradeManager.addStudent(s);
                    }
                    System.out.println("Data imported successfully!");
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 8.");
            }
        }
    }
}
