package example.price;

import example.Movie;
import example.Rental;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChildrensPriceTest {
    public static final Movie MOVIE_FOR_CHILDREN = new Movie("children", new ChildrensPrice());

    @Test
    public void whenFilmForChildrenRentedFor8Days_ShouldReturn9Dollars() {
        assertEquals(9., movieForChildrenRental(8).getCharge(), 0.01);
    }

    @Test
    public void whenFilmForChildrenRentedFor8Days_ShouldReturn1Point() {
        assertEquals(1, movieForChildrenRental(8).getFrequentRenterPointsIncrement());
    }


    private Rental movieForChildrenRental(int daysRented) {
        return new Rental(MOVIE_FOR_CHILDREN, daysRented);
    }

    @Test
    public void whenFilmForChildrenRentedFor2Days_ShouldReturn1AndHalfDollars() {
        assertEquals(1.5, movieForChildrenRental(2).getCharge(), 0.01);
    }


}
