public class SpecialSeries extends Series {
    private boolean bonusContent;

    public SpecialSeries(String seriesId, String seriesName, int ageRating, int totalEpisodes, boolean bonusContent) {
        super(seriesId, seriesName, ageRating, totalEpisodes);
        this.bonusContent = bonusContent;
    }

    public boolean hasBonusContent() { return bonusContent; }

    @Override
    public void displayReport() {
        super.displayReport();
        System.out.println("Bonus Content: " + (bonusContent ? "Yes" : "No"));
    }
}
