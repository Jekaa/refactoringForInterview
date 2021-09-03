package example;

public abstract class Price {

    abstract double getCharge(int daysRented);

    int getFrequentRenterPointsIncrement(int daysRented) {
        return 1;
    }
}