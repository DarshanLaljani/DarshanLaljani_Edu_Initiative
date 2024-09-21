import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Shape Area Calculator ---");
            System.out.println("1. Create Circle");
            System.out.println("2. Create Square");
            System.out.println("3. Create Rectangle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Shape shape = null;

            switch (option) {
                case 1:
                    // Create Circle
                    System.out.print("Enter radius of the circle: ");
                    double radius = scanner.nextDouble();
                    shape = ShapeFactory.createShape("circle", radius);
                    break;

                case 2:
                    // Create Square
                    System.out.print("Enter side length of the square: ");
                    double side = scanner.nextDouble();
                    shape = ShapeFactory.createShape("square", side);
                    break;

                case 3:
                    // Create Rectangle
                    System.out.print("Enter length of the rectangle: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width of the rectangle: ");
                    double width = scanner.nextDouble();
                    shape = ShapeFactory.createShape("rectangle", length, width);
                    break;

                case 4:
                    // Exit
                    running = false;
                    System.out.println("Exiting the program.");
                    continue;

                default:
                    System.out.println("Invalid option. Please choose again.");
                    continue;
            }

            if (shape != null) {
                System.out.println("The area of the " + shape.getClass().getSimpleName() + " is: " + shape.area());
            }
        }
        scanner.close();
    }
}
