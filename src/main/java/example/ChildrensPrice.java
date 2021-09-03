package example;

import static example.Movie.CHILDRENS;

public class ChildrensPrice extends Price {
    public ChildrensPrice() {
        super(CHILDRENS);
    }

    @Override
    double getCharge(int daysRented) {
        if (daysRented > 3) {
            return 1.5 + (daysRented - 3) * 1.5;
        }
        return 1.5;
    }
}
