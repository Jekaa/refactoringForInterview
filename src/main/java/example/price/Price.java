package example.price;

import example.Movie;

public abstract class Price {
    private final int priceCode;

    protected Price(int priceCode) {
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public abstract double getCharge(int daysRented, Movie movie);

    public int getRenterPoints(int daysRented) {
        return 1;
    }
}
