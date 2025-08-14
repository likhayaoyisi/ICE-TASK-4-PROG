import java.util.Scanner;

public class TVSeries {
    public static void main(String[] args) {
        SeriesModel app = new SeriesModel();
        Scanner scanner = new Scanner(System.in);

        System.out.println("LATEST TV SERIES - 2025");
        System.out.println("********************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String choice = scanner.nextLine().trim();

        if (!choice.equals("1")) {
            System.out.println("Goodbye!");
            scanner.close();
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series details.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025.");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter choice: ");
            String menuChoice = scanner.nextLine().trim();

            switch (menuChoice) {
                case "1" -> app.addSeries();
                case "2" -> app.findSeries();
                case "3" -> app.editSeries();
                case "4" -> app.removeSeries();
                case "5" -> app.displayReport();
                case "6" -> {
                    app.closeApplication();
                    running = false;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }
}
