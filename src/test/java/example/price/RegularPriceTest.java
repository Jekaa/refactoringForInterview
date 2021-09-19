package example.price;

import example.Movie;
import example.Rental;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularPriceTest {
    public static final Movie REGULAR_MOVIE = new Movie("regular", new RegularPrice());

    @Test
    public void whenRegularFilmRentedFor2Days_ShouldReturn2DollarsCharge() {
        assertEquals(2., regularFilmRental(2).getCharge(), 0.01);
    }

    private Rental regularFilmRental(int daysRented) {
        return new Rental(REGULAR_MOVIE, daysRented);
    }

    @Test
    public void whenRegularFilmRentedFor2Days_ShouldReturn1FrequentRenterPoint() {
        assertEquals(1, regularFilmRental(2).getFrequentRenterPointsIncrement());
    }

    @Test
    public void whenRegularFilmRentedFor5Days_ShouldReturn6AndHalfDollarsAnd1Point() {
        assertEquals(6.5, regularFilmRental(5).getCharge(), 0.01);
    }

}
