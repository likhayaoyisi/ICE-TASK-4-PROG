public class Series {
    private String seriesId;
    private String seriesName;
    private int ageRating;
    private int totalEpisodes;
    private int watchedEpisodes;
    private double rating;

    public Series(String seriesId, String seriesName, int ageRating, int totalEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.ageRating = ageRating;
        this.totalEpisodes = totalEpisodes;
        this.watchedEpisodes = 0;
        this.rating = 0.0;
    }

    // Getters & Setters
    public String getSeriesId() { return seriesId; }
    public String getSeriesName() { return seriesName; }
    public int getAgeRating() { return ageRating; }
    public int getTotalEpisodes() { return totalEpisodes; }
    public int getWatchedEpisodes() { return watchedEpisodes; }
    public double getRating() { return rating; }

    public void watchEpisodes(int episodes) {
        if (episodes + watchedEpisodes > totalEpisodes) {
            System.out.println("Cannot watch more episodes than total episodes.");
        } else {
            watchedEpisodes += episodes;
        }
    }

    public void rateSeries(double rating) {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            System.out.println("Rating must be between 0 and 10.");
        }
    }

    public void displayReport() {
        System.out.println(seriesId + "\t" + seriesName + "\t" + ageRating + "\t" + watchedEpisodes + "/" + totalEpisodes + "\t" + rating);
    }
}
