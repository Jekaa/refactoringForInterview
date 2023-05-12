package example.price;

import example.Movie;

public class NewReleasePrice extends Price {
    public NewReleasePrice() {
        super(Movie.MovieType.NEW_RELEASE.ordinal());
    }

    @Override
    public double getCharge(int daysRented, Movie movie) {
        return daysRented * 3;
    }
}
