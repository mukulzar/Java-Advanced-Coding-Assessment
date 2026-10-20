public class StudentController {
    private final StudentModel model;
    private final StudentView view;

    public StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void collectAndSaveStudent() {
        model.setId(view.getStudentId());
        model.setName(view.getStudentName());
        model.setCourse(view.getStudentCourse());
    }

    public void showStudent() {
        view.displayStudentDetails(model.getId(), model.getName(), model.getCourse());
    }
}
