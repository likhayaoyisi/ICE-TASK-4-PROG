import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SeriesModel {
    private ArrayList<Series> seriesList = new ArrayList<>();
    private Scanner inputScanner = new Scanner(System.in);

    private void drawBox(String text) {
        String border = "*".repeat(text.length() + 4);
        System.out.println(border);
        System.out.println("* " + text + " *");
        System.out.println(border);
    }
    public void addSeries() {
        drawBox("ADD NEW SERIES");

        System.out.print("Enter Series ID: ");
        String id = inputScanner.nextLine().trim();

        System.out.print("Enter Series Name: ");
        String name = inputScanner.nextLine().trim();

        int ageLimit;
        while (true) {
            System.out.print("Enter Age Restriction (2 - 18): ");
            String ageInput = inputScanner.nextLine();
            try {
                ageLimit = Integer.parseInt(ageInput);
                if (validAge(ageLimit)) break;
                System.out.println("Invalid age! Must be between 2 and 18.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numbers only.");
            }
        }
        int episodeCount;
        while (true) {
            System.out.print("Enter Number of Episodes: ");
            String epInput = inputScanner.nextLine();
            try {
                episodeCount = Integer.parseInt(epInput);
                if (episodeCount > 0) break;
                System.out.println("Invalid! Must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numbers only.");
            }
        }

        seriesList.add(new Series(id, name, ageLimit, episodeCount));
        drawBox("Series successfully saved!");
    }

    public void findSeries() {
        drawBox("SEARCH FOR A SERIES");
        System.out.print("Enter Series ID to search: ");
        String id = inputScanner.nextLine().trim();

        Series found = seriesList.stream()
                .filter(s -> s.getSeriesId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);

        if (found != null) {
            System.out.println("\n=== SERIES FOUND ===");
            System.out.println(found);
        } else {
            System.out.println("\nNo series found with ID: " + id);
        }
    }

    public void editSeries() {
        drawBox("UPDATE SERIES");
        System.out.print("Enter Series ID to update: ");
        String id = inputScanner.nextLine().trim();

        Series s = seriesList.stream()
                .filter(series -> series.getSeriesId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);

        if (s == null) {
            System.out.println("No series found with ID: " + id);
            return;
        }

        System.out.print("Enter new Series Name: ");
        s.setSeriesName(inputScanner.nextLine().trim());

        int newAge;
        while (true) {
            System.out.print("Enter new Age Restriction (2 - 18): ");
            String ageInput = inputScanner.nextLine();
            try {
                newAge = Integer.parseInt(ageInput);
                if (validAge(newAge)) break;
                System.out.println("Invalid age! Must be between 2 and 18.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numbers only.");
            }
        }
        s.setSeriesAge(newAge);

        int newEpisodes;
        while (true) {
            System.out.print("Enter new Number of Episodes: ");
            String epInput = inputScanner.nextLine();
            try {
                newEpisodes = Integer.parseInt(epInput);
                if (newEpisodes > 0) break;
                System.out.println("Invalid! Must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numbers only.");
            }
        }
        s.setSeriesEpisodes(newEpisodes);

        drawBox("Series updated successfully!");
    }

    public void removeSeries() {
        drawBox("DELETE SERIES");
        System.out.print("Enter Series ID to delete: ");
        String id = inputScanner.nextLine().trim();

        Iterator<Series> iterator = seriesList.iterator();
        while (iterator.hasNext()) {
            Series s = iterator.next();
            if (s.getSeriesId().equalsIgnoreCase(id)) {
                System.out.print("Are you sure you want to delete this series? (Y/N): ");
                String confirm = inputScanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    iterator.remove();
                    drawBox("Series deleted successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }
        System.out.println("No series found with ID: " + id);
    }

    public void displayReport() {
        drawBox("LATEST SERIES REPORT - 2025");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        } else {
            for (Series s : seriesList) {
                System.out.println(s);
                System.out.println("-----------------------------");
            }
        }
    }

    public void closeApplication() {
        drawBox("EXITING APPLICATION");
        inputScanner.close();
        System.exit(0);
    }

    public boolean validAge(int age) {
        return age >= 2 && age <= 18;
    }
}
