package example;

import example.price.Price;
import example.price.RegularPrice;

public class Movie {
    private final String title;
    private final Price price;

    public Price getPrice() {
        return price;
    }

    public enum MovieType {
        REGULAR, NEW_RELEASE, CHILDRENS
    }

    public Movie(String title, int priceCode) {
        this.title = title;
        this.price = createPrice(priceCode);
    }

    private Price createPrice(int priceCode) {
        if (priceCode == MovieType.REGULAR.ordinal()) {
            return new RegularPrice();
        }
        return new Price(priceCode);
    }

    public MovieType getPriceCode() {
        if (price.getPriceCode() > MovieType.values().length) {
            throw new IllegalArgumentException(price.getPriceCode() + " not found");
        }
        return MovieType.values()[price.getPriceCode()];
    }

    public String getTitle (){
        return title;
    }
}