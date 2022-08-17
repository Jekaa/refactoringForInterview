package example;

public class NewReleasesMovieType implements MovieType {
    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 0;
        //determine amounts for rental line
        thisAmount += daysRented * 3;
        return thisAmount;
    }

    @Override
    public int getRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }
}
