package example;

public class MovieTypeEnum implements MovieType {

    public static final MovieType NEW_RELEASE = new NewReleasesMovieType();
    public static final MovieType CHILDRENS = new ChildrensMovieType();
    public static final MovieType REGULAR = new RegularMovieType();

    @Override
    public double getAmount(int daysRented) {
        return 0;
    }
}
