import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course course = new BasicCourse();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Online Course Builder ---");
            System.out.println("1. Add Quiz ( Adds $10 to Selling Price ) ");
            System.out.println("2. Add Project ( Adds $20 to Selling Price ) ");
            System.out.println("3. Add Certificate ( Adds $15 to Selling Price ) ");
            System.out.println("4. Show Final Course");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    course = new QuizDecorator(course);
                    System.out.println("Quiz added to the course!");
                    break;

                case 2:
                    course = new ProjectDecorator(course);
                    System.out.println("Project added to the course!");
                    break;

                case 3:
                    course = new CertificateDecorator(course);
                    System.out.println("Certificate added to the course!");
                    break;

                case 4:
                    System.out.println("Your course: " + course.getDescription());
                    System.out.println("Total cost: $" + course.getCost());
                    break;

                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
