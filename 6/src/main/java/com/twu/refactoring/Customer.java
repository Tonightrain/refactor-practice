package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		StringBuilder result1=new StringBuilder();
		result1.append("Rental Record for ").append(getName()).append("\n");

		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();

			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}

			frequentRenterPoints++;
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;

			result1.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
			totalAmount += thisAmount;

		}
		result1.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n")
				.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
		return result1.toString();
	}

}
