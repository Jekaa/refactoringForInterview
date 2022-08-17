package example;

import java.util.List;

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
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle()+ "\t" + rental.getThisAmount() + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalAmount() + "\n";
        result += "You earned " + getFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private int getFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPointsIncrement).sum();
    }

    private double getTotalAmount() {
        return rentals.stream().mapToDouble(Rental::getThisAmount).sum();
    }


}
