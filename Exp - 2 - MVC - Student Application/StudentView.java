import java.util.Scanner;

public class StudentView {
    private final Scanner scanner = new Scanner(System.in);

    public String getStudentId() {
        System.out.print("Enter Student ID: ");
        return scanner.nextLine();
    }

    public String getStudentName() {
        System.out.print("Enter Student Name: ");
        return scanner.nextLine();
    }

    public String getStudentCourse() {
        System.out.print("Enter Course: ");
        return scanner.nextLine();
    }

    public void displayStudentDetails(String id, String name, String course) {
        System.out.println();
        System.out.println("----- Student Details -----");
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Course : " + course);
        System.out.println("---------------------------");
    }
}
