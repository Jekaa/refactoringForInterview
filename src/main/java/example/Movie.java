package example;

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
        this.price = new Price(priceCode);
    }

    public MovieType getPriceCode() {
        if (price.getPriceCode() > MovieType.values().length) {
            throw new IllegalArgumentException();
        }
        return MovieType.values()[price.getPriceCode()];
    }

    public String getTitle (){
        return title;
    }
}