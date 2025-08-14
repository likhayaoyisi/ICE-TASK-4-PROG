public class SeriesManager {
    private Series[] seriesArray;
    private int count;

    public SeriesManager(int capacity) {
        seriesArray = new Series[capacity];
        count = 0;
    }

    public void addSeries(Series series) {
        if (count < seriesArray.length) {
            seriesArray[count++] = series;
        } else {
            System.out.println("No space to add more series.");
        }
    }

    public Series searchSeries(String seriesId) {
        for (int i = 0; i < count; i++) {
            if (seriesArray[i].getSeriesId().equals(seriesId)) {
                return seriesArray[i];
            }
        }
        return null;
    }

    public boolean updateSeries(String seriesId, int watchedEpisodes, double rating) {
        Series s = searchSeries(seriesId);
        if (s != null) {
            s.watchEpisodes(watchedEpisodes);
            s.rateSeries(rating);
            return true;
        }
        return false;
    }

    public boolean deleteSeries(String seriesId) {
        for (int i = 0; i < count; i++) {
            if (seriesArray[i].getSeriesId().equals(seriesId)) {
                // Shift array elements to remove the series
                for (int j = i; j < count - 1; j++) {
                    seriesArray[j] = seriesArray[j + 1];
                }
                seriesArray[--count] = null;
                return true;
            }
        }
        return false;
    }

    public boolean checkAgeRestriction(String seriesId, int viewerAge) {
        Series s = searchSeries(seriesId);
        if (s != null) {
            return viewerAge >= s.getAgeRating();
        }
        return false;
    }

    public Series[] getAllSeries() {
        Series[] result = new Series[count];
        for (int i = 0; i < count; i++) result[i] = seriesArray[i];
        return result;
    }
}
