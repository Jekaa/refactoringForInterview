package example.price;

import example.Movie;

public class NewReleasePrice extends Price {
    public NewReleasePrice() {
        super(Movie.MovieType.NEW_RELEASE);
    }

    @Override
    public double getCharge(int daysRented, Movie movie) {
        return daysRented * 3;
    }

    @Override
    public int getRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }
}
