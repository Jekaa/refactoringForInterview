package example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    public static final Movie REGULAR_MOVIE = new Movie("regular", new RegularPrice());
    public static final Movie NEW_RELEASE_MOVIE = new Movie("new release", new NewReleasePrice());
    public static final Movie MOVIE_FOR_CHILDREN = new Movie("children", new ChildrensPrice());

    @Test
    public void whenRegularFilmRentedFor2Days_ShouldReturn2DollarsAnd1Point() {
        String expected = """
                Rental Record for CustomerName
                \tregular\t2.0
                Amount owed is 2.0
                You earned 1 frequent renter points""";

        assertEquals(expected, getStatementFor(List.of(regularFilmRental(2))));
    }

    private Rental regularFilmRental(int daysRented) {
        return new Rental(REGULAR_MOVIE, daysRented);
    }

    @Test
    public void whenRegularFilmRentedFor5Days_ShouldReturn6dot5DollarsAnd1Point() {
        String expected = """
                Rental Record for CustomerName
                \tregular\t6.5
                Amount owed is 6.5
                You earned 1 frequent renter points""";

        assertEquals(expected, getStatementFor(List.of(regularFilmRental(5))));
    }

    private String getStatementFor(List<Rental> rentals) {
        return new Customer("CustomerName", rentals).statement();
    }

    @Test
    public void whenNewReleaseFilmRentedFor8Days_ShouldReturn24DollarsAnd2Point() {
        String expected = """
                Rental Record for CustomerName
                \tnew release\t24.0
                Amount owed is 24.0
                You earned 2 frequent renter points""";

        assertEquals(expected, getStatementFor(List.of(newReleaseRental())));
    }

    private Rental newReleaseRental() {
        return new Rental(NEW_RELEASE_MOVIE, 8);
    }

    @Test
    public void whenFilmForChildrenRentedFor8Days_ShouldReturn9DollarsAnd1Point() {
        String expected = """
                Rental Record for CustomerName
                \tchildren\t9.0
                Amount owed is 9.0
                You earned 1 frequent renter points""";

        assertEquals(expected, getStatementFor(List.of(movieForChildrenRental(8))));
    }

    private Rental movieForChildrenRental(int daysRented) {
        return new Rental(MOVIE_FOR_CHILDREN, daysRented);
    }

    @Test
    public void whenFilmForChildrenRentedFor2Days_ShouldReturn1n5DollarsAnd1Point() {
        String expected = """
                Rental Record for CustomerName
                \tchildren\t1.5
                Amount owed is 1.5
                You earned 1 frequent renter points""";

        assertEquals(expected, getStatementFor(List.of(movieForChildrenRental(2))));
    }

    @Test
    public void whenAllFilmsTogether_ShouldConcatenateData() {
        String expected = """
                Rental Record for CustomerName
                \tregular\t11.0
                \tnew release\t24.0
                \tchildren\t1.5
                Amount owed is 36.5
                You earned 4 frequent renter points""";

        assertEquals(expected, getStatementFor(severalRentals()));
    }

    private List<Rental> severalRentals() {
        return List.of(
                regularFilmRental(8),
                newReleaseRental(),
                movieForChildrenRental(2));
    }

}