package example;

public abstract class Price {
    private final int priceCode;

    public Price(int priceCode) {
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    abstract double getCharge(int daysRented);

    int getFrequentRenterPointsIncrement(int daysRented) {
        return 1;
    }
}