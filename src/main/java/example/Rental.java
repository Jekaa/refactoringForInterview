package example;

import static example.Movie.MovieType.NEW_RELEASE;

class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getThisAmount() {
        double thisAmount = 0;
        //determine amounts for rental line
        switch (getMovie().getPriceCode()) {
            case REGULAR -> {
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 1.5;
            }
            case NEW_RELEASE -> thisAmount += getDaysRented() * 3;
            case CHILDRENS -> {
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 1.5;
            }
        }
        return thisAmount;
    }

    int getFrequentRenterPointsIncrement() {
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == NEW_RELEASE) && getDaysRented() > 1)
            return 2;
        return 1;
    }
}
