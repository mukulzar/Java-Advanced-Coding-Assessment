public class Main {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        System.out.println("Student Management Application (MVC)");
        System.out.println();

        controller.collectAndSaveStudent();
        controller.showStudent();
    }
}
