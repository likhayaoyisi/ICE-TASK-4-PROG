import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SeriesManagerTest {

    @Test
    void TestSearchSeries() {
        SeriesManager manager = new SeriesManager(5);
        Series s1 = new Series("S001", "Stranger Things", 16, 34);
        manager.addSeries(s1);

        Series result = manager.searchSeries("S001");
        assertNotNull(result);
        assertEquals("Stranger Things", result.getSeriesName());
    }

    @Test
    void TestSearchSeries_SeriesNotFound() {
        SeriesManager manager = new SeriesManager(5);
        Series result = manager.searchSeries("S999");
        assertNull(result);
    }

    @Test
    void TestUpdateSeries() {
        SeriesManager manager = new SeriesManager(5);
        Series s1 = new Series("S002", "Chernobyl", 18, 5);
        manager.addSeries(s1);

        boolean updated = manager.updateSeries("S002", 3, 9.5);
        assertTrue(updated);
        assertEquals(3, s1.getWatchedEpisodes());
        assertEquals(9.5, s1.getRating());
    }

    @Test
    void TestDeleteSeries() {
        SeriesManager manager = new SeriesManager(5);
        Series s1 = new Series("S003", "Breaking Bad", 18, 62);
        manager.addSeries(s1);

        boolean deleted = manager.deleteSeries("S003");
        assertTrue(deleted);
        assertNull(manager.searchSeries("S003"));
    }

    @Test
    void TestDeleteSeries_SeriesNotFound() {
        SeriesManager manager = new SeriesManager(5);
        boolean deleted = manager.deleteSeries("S999");
        assertFalse(deleted);
    }

    @Test
    void TestSeriesAgeRestriction_AgeValid() {
        SeriesManager manager = new SeriesManager(5);
        Series s1 = new Series("S004", "Friends", 13, 236);
        manager.addSeries(s1);

        boolean canWatch = manager.checkAgeRestriction("S004", 15);
        assertTrue(canWatch);
    }

    @Test
    void TestSeriesAgeRestriction_SeriesAgeInValid() {
        SeriesManager manager = new SeriesManager(5);
        Series s1 = new Series("S005", "Game of Thrones", 18, 73);
        manager.addSeries(s1);

        boolean canWatch = manager.checkAgeRestriction("S005", 16);
        assertFalse(canWatch);
    }
}
