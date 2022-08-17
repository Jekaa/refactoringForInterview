package example;

public enum MovieTypeEnum implements MovieType {
    REGULAR, NEW_RELEASE, CHILDRENS;

    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 0;
        //determine amounts for rental line
        switch (this) {
            case REGULAR -> {
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
            }
            case NEW_RELEASE -> thisAmount += daysRented * 3;
            case CHILDRENS -> {
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
            }
        }
        return thisAmount;
    }
}
