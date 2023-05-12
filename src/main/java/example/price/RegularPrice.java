package example.price;

import example.Movie;

public class RegularPrice extends Price {
    public RegularPrice() {
        super(Movie.MovieType.REGULAR.ordinal());
    }

    @Override
    public double getCharge(int daysRented, Movie movie) {
        if (daysRented > 2)
            return 2 + (daysRented - 2) * 1.5;
        return 2;
    }
}
