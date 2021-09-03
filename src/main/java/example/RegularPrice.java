package example;

import static example.Movie.REGULAR;

public class RegularPrice extends Price {
    public RegularPrice() {
        super(REGULAR);
    }

    @Override
    double charge(int daysRented) {
        if (daysRented > 2) {
            return 2 + (daysRented - 2) * 1.5;
        }
        return 2;
    }
}
