package example.price;

import example.Movie;

public abstract class Price {
    private final Movie.MovieType movieType;

    protected Price(Movie.MovieType movieType) {
        this.movieType = movieType;
    }

    public abstract double getCharge(int daysRented, Movie movie);

    public int getRenterPoints(int daysRented) {
        return 1;
    }
}
