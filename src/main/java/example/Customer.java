package example;

import java.util.List;

import static example.Movie.MovieType.*;

@SuppressWarnings("StringConcatenationInLoop")
class Customer {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }


    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            frequentRenterPoints += getFrequentRenterPointsIncrement(rental);
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle()+ "\t" + rental.getThisAmount() + "\n";
            totalAmount += rental.getThisAmount();
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private int getFrequentRenterPointsIncrement(Rental rental) {
        // add bonus for a two day new release rental
        if ((rental.getMovie().getPriceCode() == NEW_RELEASE) && rental.getDaysRented() > 1)
            return 2;
        return 1;
    }


}
