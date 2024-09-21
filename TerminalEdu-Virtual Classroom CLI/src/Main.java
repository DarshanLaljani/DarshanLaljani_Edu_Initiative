import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Virtual Classroom Manager!");

        while (true) {
            System.out.print("Enter a command (or 'help' for instructions): ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("help")) {
                printHelp();
            } else if (command.startsWith("add_classroom")) {
                String[] parts = command.split("\\s+", 2);
                if (parts.length == 2) {
                    manager.addClassroom(parts[1]);
                } else {
                    System.out.println("Error: Please provide a class name.");
                }
            } else if (command.startsWith("add_student")) {
                String[] parts = command.split("\\s+", 3);
                if (parts.length == 3) {
                    manager.addStudent(parts[1], parts[2]);
                } else {
                    System.out.println("Error: Please provide student ID and class name.");
                }
            } else if (command.startsWith("schedule_assignment")) {
                String[] parts = command.split("\\s+", 3);
                if (parts.length == 3) {
                    manager.scheduleAssignment(parts[1], parts[2]);
                } else {
                    System.out.println("Error: Please provide class name and assignment details.");
                }
            } else if (command.startsWith("submit_assignment")) {
                String[] parts = command.split("\\s+", 4);
                if (parts.length == 4) {
                    manager.submitAssignment(parts[1], parts[2], parts[3]);
                } else {
                    System.out.println("Error: Please provide student ID, class name, and assignment details.");
                }
            } else if (command.equals("list_classrooms")) {
                manager.listClassrooms();
            } else if (command.startsWith("list_students")) {
                String[] parts = command.split("\\s+", 2);
                if (parts.length == 2) {
                    manager.listStudents(parts[1]);
                } else {
                    System.out.println("Error: Please provide a class name.");
                }
            } else if (command.equals("quit")) {
                System.out.println("Thank you for using the Virtual Classroom Manager. Goodbye!");
                break;
            } else {
                System.out.println("Invalid command. Type 'help' for instructions.");
            }
        }

        scanner.close();
    }

    private static void printHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("add_classroom <class_name>");
        System.out.println("add_student <student_id> <class_name>");
        System.out.println("schedule_assignment <class_name> <assignment_details>");
        System.out.println("submit_assignment <student_id> <class_name> <assignment_details>");
        System.out.println("list_classrooms");
        System.out.println("list_students <class_name>");
        System.out.println("quit");
    }
}