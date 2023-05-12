package example;

import static example.Movie.MovieType.NEW_RELEASE;

public class Movie {
    private final String title;
    private final Price price;

    double charge(int daysRented) {
        double charge = 0;
        //determine amounts for rental line
        switch (getPriceCode()) {
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

    int renterPoints(int daysRented) {
        int frequentRenterPoints = 0;
        // add frequent renter points
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((getPriceCode() == NEW_RELEASE) && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public enum MovieType {
        REGULAR, NEW_RELEASE, CHILDRENS
    }

    public Movie(String title, int priceCode) {
        this.title = title;
        this.price = new Price(priceCode);
    }

    public MovieType getPriceCode() {
        if (price.getPriceCode() > MovieType.values().length) {
            throw new IllegalArgumentException();
        }
        return MovieType.values()[price.getPriceCode()];
    }

    public String getTitle (){
        return title;
    }
}