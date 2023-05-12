package example;

import example.price.Price;

public class Movie {
    private final String title;
    private final Price price;

    public Price getPrice() {
        return price;
    }

    public enum MovieType {
        REGULAR, NEW_RELEASE, CHILDRENS
    }

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle (){
        return title;
    }
}