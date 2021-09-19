package example.price;

import example.Movie;
import example.Rental;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewReleasePriceTest {
    public static final Movie NEW_RELEASE_MOVIE = new Movie("new release", new NewReleasePrice());

    @Test
    public void whenNewReleaseFilmRentedFor8Days_ShouldReturn24Dollars() {
        assertEquals(24., newReleaseRental().getCharge(), 0.01);
    }

    @Test
    public void whenNewReleaseFilmRentedFor8Days_ShouldReturn2Points() {
        assertEquals(2, newReleaseRental().getFrequentRenterPointsIncrement());
    }

    private Rental newReleaseRental() {
        return new Rental(NEW_RELEASE_MOVIE, 8);
    }


}
