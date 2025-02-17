/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author ARIF ZAKWAN
 */
public class FileManager {
    
    public static void exportDataToFile(String filename, ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getPersonId() + "," + student.getStudentId() + ",");
                writer.write(student.getGrades().toString().replaceAll("[\\[\\]]", ""));
                writer.newLine();
            }
            System.out.println("Data exported successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting data: " + e.getMessage());
        }
    }
    
    public static ArrayList<Student> importDataFromFile(String filename) {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3) continue; 

                String name = parts[0];
                String personId = parts[1];
                String studentId = parts[2];
                Student student = new Student(name, personId, studentId);
                
                for (int i = 3; i < parts.length; i++) {
                    student.addGrade(Double.parseDouble(parts[i]));
                }

                students.add(student);
            }
            System.out.println("Data imported successfully from " + filename);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error importing data: " + e.getMessage());
        }
        return students;
    }
}
