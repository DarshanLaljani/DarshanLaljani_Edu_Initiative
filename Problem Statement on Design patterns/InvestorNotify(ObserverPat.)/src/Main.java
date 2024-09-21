import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the stock
        System.out.print("Enter stock symbol: ");
        String stockSymbol = scanner.nextLine();
        System.out.print("Enter initial stock price: ");
        double stockPrice = scanner.nextDouble();
        Stock stock = new Stock(stockSymbol, stockPrice);

        // Menu for user interaction
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add an Investor");
            System.out.println("2. Remove an Investor");
            System.out.println("3. Change Stock Price");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left by nextInt()

            switch (option) {
                case 1:
                    // Add a new investor
                    System.out.print("Enter investor name: ");
                    String investorName = scanner.nextLine();
                    Investor newInvestor = new Investor(investorName);
                    stock.registerObserver(newInvestor);
                    System.out.println(investorName + " has been added as an investor.");
                    break;

                case 2:
                    // Remove an investor
                    System.out.print("Enter investor name to remove: ");
                    String removeInvestorName = scanner.nextLine();
                    boolean removed = false;
                    for (Observer observer : stock.observers) {
                        if (observer instanceof Investor) {
                            Investor investor = (Investor) observer;
                            if (investor.getName().equals(removeInvestorName)) {
                                stock.removeObserver(investor);
                                removed = true;
                                System.out.println(removeInvestorName + " has been removed.");
                                break;
                            }
                        }
                    }
                    if (!removed) {
                        System.out.println("Investor not found.");
                    }
                    break;

                case 3:
                    // Change stock price
                    System.out.print("Enter new stock price: ");
                    double newPrice = scanner.nextDouble();
                    stock.setPrice(newPrice);
                    System.out.println("Stock price has been updated.");
                    break;

                case 4:
                    // Exit the program
                    running = false;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
