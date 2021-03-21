package JDBC_Assignment1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Scanner in = new Scanner(System.in);
		List<String> order_date = new ArrayList<String>();
		List<Double> total = new ArrayList<Double>();

		OrderInfo orders;
		String db_name = "storefront", order_status = "shipped";
		int user_id;

		API api = new API(db_name);

		System.out.print("Enter user id :");
		user_id = in.nextInt();
		orders = new OrderInfo(user_id);

		ResultSet resultSet = api.fetchOrders(user_id, order_status);

		while (resultSet.next()) {
			order_date.add(resultSet.getDate("order_date").toString());
			total.add(resultSet.getDouble("total"));
		}
		if (order_date.size() > 0) {
			orders.setOrderDate(order_date);
			orders.setTotal(total);
			orders.display();
		} else {
			System.out.println("User not found");
		}

		api.closeDB();
	}
}
