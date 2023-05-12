package example.price;

import example.Movie;

public class ChildrenPrice extends Price {
    public ChildrenPrice() {
        super(Movie.MovieType.CHILDRENS.ordinal());
    }

    @Override
    public double getCharge(int daysRented, Movie movie) {
        if (daysRented > 3)
            return 1.5 + (daysRented - 3) * 1.5;
        return 1.5;
    }
}
