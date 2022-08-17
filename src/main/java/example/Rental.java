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

    double getThisAmount() {
        return getMovie().getPriceCode().getAmount(getDaysRented());
    }

    int getFrequentRenterPointsIncrement() {
        // add bonus for a two day new release rental
        return getMovie().getPriceCode().getRenterPoints(getDaysRented());
    }

}
