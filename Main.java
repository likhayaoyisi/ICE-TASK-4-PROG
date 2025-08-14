import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Series[] seriesArray = new Series[5]; // max 5 series
        Scanner sc = new Scanner(System.in);

        // Example series
        seriesArray[0] = new Series("S001", "Stranger Things", 16, 34);
        seriesArray[1] = new SpecialSeries("S002", "Chernobyl", 18, 5, true);

        // Watch episodes & rate series
        seriesArray[0].watchEpisodes(3);
        seriesArray[0].rateSeries(9.0);

        seriesArray[1].watchEpisodes(5);
        seriesArray[1].rateSeries(10.0);

        // Display report
        System.out.println("ID\tName\tAge\tWatched\tRating\tBonus");
        for (Series s : seriesArray) {
            if (s != null) {
                s.displayReport();
            }
        }
    }
}
