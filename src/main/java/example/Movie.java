package example;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;


    private final String title;
    private final Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        price = createPrice(priceCode);
    }

    private Price createPrice(int priceCode) {
        if (priceCode == REGULAR) return new RegularPrice();
        return new Price(priceCode);
    }

    public String getTitle (){
        return title;
    }

    public Price getPrice() {
        return price;
    }

}