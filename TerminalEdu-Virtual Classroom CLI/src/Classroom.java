import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String name;
    private List<String> students;
    private List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getStudents() {
        return students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addStudent(String studentId) {
        students.add(studentId);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}