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
}
