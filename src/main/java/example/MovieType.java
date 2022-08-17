package example;

public interface MovieType {
    double getAmount(int daysRented);

    default int getRenterPoints(int daysRented) {
        return 1;
    }
}
