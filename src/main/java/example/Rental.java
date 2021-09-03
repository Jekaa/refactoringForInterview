package example;

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

    double getCharge() {
        double charge = 0;
        //determine amounts for rental line
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                charge += 2;
                if (getDaysRented() > 2)
                    charge += (getDaysRented() - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> charge += getDaysRented() * 3;
            case Movie.CHILDRENS -> {
                charge += 1.5;
                if (getDaysRented() > 3)
                    charge += (getDaysRented() - 3) * 1.5;
            }
        }
        return charge;
    }

    int getFrequentRenterPointsIncrement() {
        // add frequent renter points
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
