import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
public class VirtualClassroomManager {
    private Map<String, Classroom> classrooms;
    private static final Logger logger = Logger.getLogger(VirtualClassroomManager.class.getName());

    public VirtualClassroomManager() {
        this.classrooms = new HashMap<>();
    }

    public void addClassroom(String name) {
        try {
            if (classrooms.containsKey(name)) {
                throw new IllegalArgumentException("Classroom " + name + " already exists.");
            }
            classrooms.put(name, new Classroom(name));
            logger.info("Classroom " + name + " has been created.");
            System.out.println("Classroom " + name + " has been created.");
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addStudent(String studentId, String className) {
        try {
            if (!classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Classroom " + className + " does not exist.");
            }
            Classroom classroom = classrooms.get(className);
            if (classroom.getStudents().contains(studentId)) {
                throw new IllegalArgumentException("Student " + studentId + " is already enrolled in " + className + ".");
            }
            classroom.addStudent(studentId);
            logger.info("Student " + studentId + " has been enrolled in " + className + ".");
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        try {
            if (!classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Classroom " + className + " does not exist.");
            }
            Classroom classroom = classrooms.get(className);
            classroom.addAssignment(new Assignment(assignmentDetails));
            logger.info("Assignment for " + className + " has been scheduled.");
            System.out.println("Assignment for " + className + " has been scheduled.");
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        try {
            if (!classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Classroom " + className + " does not exist.");
            }
            Classroom classroom = classrooms.get(className);
            if (!classroom.getStudents().contains(studentId)) {
                throw new IllegalArgumentException("Student " + studentId + " is not enrolled in " + className + ".");
            }
            Assignment assignment = classroom.getAssignments().stream()
                    .filter(a -> a.getDetails().equals(assignmentDetails))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Assignment '" + assignmentDetails + "' not found in " + className + "."));
            if (assignment.getSubmittedBy().contains(studentId)) {
                throw new IllegalArgumentException("Student " + studentId + " has already submitted this assignment.");
            }
            assignment.addSubmission(studentId);
            logger.info("Assignment submitted by Student " + studentId + " in " + className + ".");
            System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
        } else {
            System.out.println("Available classrooms:");
            for (String name : classrooms.keySet()) {
                System.out.println("- " + name);
            }
        }
    }

    public void listStudents(String className) {
        try {
            if (!classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Classroom " + className + " does not exist.");
            }
            Classroom classroom = classrooms.get(className);
            List<String> students = classroom.getStudents();
            if (students.isEmpty()) {
                System.out.println("No students enrolled in " + className + ".");
            } else {
                System.out.println("Students in " + className + ":");
                for (String student : students) {
                    System.out.println("- " + student);
                }
            }
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }
}
