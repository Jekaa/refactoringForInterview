package example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerTest {

    @Test
    public void whenSeveralRentalsPassedToPlainTextStatement_shouldSumChargesAndFrequentPoints() {
        String expected = """
                Rental Record for CustomerName
                \tregular\t11.0
                \tnew release\t24.0
                \tchildren\t1.5
                Amount owed is 36.5
                You earned 4 frequent renter points """;

        assertEquals(expected, createCustomer().statement());
    }

    @Test
    public void whenSeveralRentalsPassedToHtmlStatement_shouldSumChargesAndFrequentPoints() {
        String expected = """
                <H1>Rentals for <EM>CustomerName</EM></ H1><P>
                regular: 11.0<BR>
                new release: 24.0<BR>
                children: 1.5<BR>
                <P>You owe <EM>36.5</EM><P>
                On this rental you earned <EM>4</EM> frequent renter points<P>""";

        assertEquals(expected, createCustomer().htmlStatement());
    }

    private Customer createCustomer() {
        return new Customer("CustomerName", severalRentals());
    }


    private List<Rental> severalRentals() {

        return List.of(
                mockRental(11., 1, "regular"),
                mockRental(24., 2, "new release"),
                mockRental(1.5, 1, "children"));
    }

    private Rental mockRental(double charge, int renterPoints, String title) {
        final Rental rental = Mockito.mock(Rental.class, RETURNS_DEEP_STUBS);
        when(rental.getMovie().getTitle()).thenReturn(title);
        doReturn(charge).when(rental).getCharge();
        doReturn(renterPoints).when(rental).getFrequentRenterPointsIncrement();
        return rental;
    }

}