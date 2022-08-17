package example;

public enum MovieTypeEnum implements MovieType {

    NEW_RELEASE;
    public static final MovieType CHILDRENS = new ChildrensMovieType();
    public static final MovieType REGULAR = new RegularMovieType();

    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 0;
        //determine amounts for rental line
        if (this == MovieTypeEnum.NEW_RELEASE) {
            thisAmount += daysRented * 3;
        }
        return thisAmount;
    }
}
