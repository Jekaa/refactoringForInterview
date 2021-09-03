package example;

public class NewReleasePrice extends Price {

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
