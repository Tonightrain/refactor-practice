package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		// print headers
		output.append("======Printing Orders======\n");

		output.append(o.toString());

		// prints lineItems
		double totSalesTx = 0d;
		double tot = 0d;
		for (LineItem lineItem : o.getLineItems()) {
			output.append(lineItem.toString());

            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            tot += lineItem.totalAmount() + salesTax;
		}

		// prints the state tax
		output.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
		output.append("Total Amount").append('\t').append(tot);
		return output.toString();
	}
}