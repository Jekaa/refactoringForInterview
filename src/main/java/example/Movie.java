package example;

import example.price.ChildrenPrice;
import example.price.NewReleasePrice;
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
        if (priceCode == MovieType.NEW_RELEASE.ordinal()) {
            return new NewReleasePrice();
        }
        if (priceCode == MovieType.CHILDRENS.ordinal()) {
            return new ChildrenPrice();
        }
        throw new IllegalArgumentException(priceCode + " not found");
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