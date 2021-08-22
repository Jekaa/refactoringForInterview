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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            double thisAmount = getCharge(each);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private double getCharge(Rental rental) {
        double charge = 0;
        //determine amounts for rental line
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                charge += 2;
                if (rental.getDaysRented() > 2)
                    charge += (rental.getDaysRented() - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> charge += rental.getDaysRented() * 3;
            case Movie.CHILDRENS -> {
                charge += 1.5;
                if (rental.getDaysRented() > 3)
                    charge += (rental.getDaysRented() - 3) * 1.5;
            }
        }
        return charge;
    }


}
