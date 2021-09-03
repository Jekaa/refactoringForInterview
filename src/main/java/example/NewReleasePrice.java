package example;

import static example.Movie.NEW_RELEASE;

public class NewReleasePrice extends Price {
    public NewReleasePrice() {
        super(NEW_RELEASE);
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPointsIncrement(int daysRented) {
        // add bonus for a two day new release rental
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
