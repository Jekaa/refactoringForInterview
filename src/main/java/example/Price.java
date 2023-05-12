package example;

import static example.Movie.MovieType.NEW_RELEASE;

public class Price {
    private final int priceCode;

    public Price(int priceCode) {
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    double charge(int daysRented, Movie movie) {
        double charge = 0;
        //determine amounts for rental line
        switch (movie.getPriceCode()) {
            case REGULAR -> {
                charge += 2;
                if (daysRented > 2)
                    charge += (daysRented - 2) * 1.5;
            }
            case NEW_RELEASE -> charge += daysRented * 3;
            case CHILDRENS -> {
                charge += 1.5;
                if (daysRented > 3)
                    charge += (daysRented - 3) * 1.5;
            }
        }
        return charge;
    }

    int renterPoints(int daysRented, Movie movie) {
        int frequentRenterPoints = 0;
        // add frequent renter points
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((movie.getPriceCode() == NEW_RELEASE) && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
