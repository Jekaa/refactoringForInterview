package example;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;


    private final String title;
    private final Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        price = new Price(priceCode);
    }

    public String getTitle (){
        return title;
    };

    double charge(int daysRented) {
        double charge = 0;
        //determine amounts for rental line
        switch (price.getPriceCode()) {
            case REGULAR -> {
                charge += 2;
                if (daysRented > 2)
                    charge += (daysRented - 2) * 1.5;
            }
            case NEW_RELEASE -> charge += daysRented * 3;
            case CHILDRENS -> {
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
        if ((price.getPriceCode() == NEW_RELEASE) && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}