package JDBC_Assignment1;

import java.util.ArrayList;
import java.util.List;

//Class for order information
public class OrderInfo {
	private int shopper_id;
	private List<String> order_date;
	private List<Double> total;

	// Constructor
	public OrderInfo(int shopperId) {
		shopper_id = shopperId;
		order_date = new ArrayList<String>();
		total = new ArrayList<Double>();
	}

	/*
	 * Setter method for order_date
	 */
	public void setOrderDate(List<String> orderDate) {
		for (String date : orderDate) {
			order_date.add(date);
		}
	}

	// Setter method for total
	public void setTotal(List<Double> totalAmount) {
		for (double amount : totalAmount) {
			total.add(amount);
		}
	}

	// Method to diplay details
	public void display() {
		System.out.println("Shopper ID :" + shopper_id);
		for (int i = 0; i < order_date.size(); ++i) {
			System.out.println("Order Date :" + order_date.get(i));
			System.out.println("Total Amount :" + total.get(i));
			System.out.println();
		}

	}
}
