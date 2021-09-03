package example;

public class Price {
    private final int priceCode;

    public Price(int priceCode) {
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    double charge(int daysRented) {
        double charge = 0;
        //determine amounts for rental line
        switch (getPriceCode()) {
            case Movie.REGULAR -> {
                charge += 2;
                if (daysRented > 2)
                    charge += (daysRented - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> charge += daysRented * 3;
            case Movie.CHILDRENS -> {
                charge += 1.5;
                if (daysRented > 3)
                    charge += (daysRented - 3) * 1.5;
            }
        }
        return charge;
    }

    int frequentPoints(int daysRented) {
        // add frequent renter points
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}