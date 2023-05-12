package example.price;

import example.Movie;

import static example.Movie.MovieType.NEW_RELEASE;

public abstract class Price {
    private final int priceCode;

    public Price(int priceCode) {
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public abstract double getCharge(int daysRented, Movie movie);

    public int getRenterPoints(int daysRented, Movie movie) {
        int frequentRenterPoints = 0;
        // add frequent renter points
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((movie.getPriceCode() == NEW_RELEASE) && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
