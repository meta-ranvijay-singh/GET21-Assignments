package JDBC_Assignment1;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Scanner in = new Scanner(System.in);

		String db_name = "storefront", order_status = "shipped";
		int user_id;

		API api = new API(db_name);

		System.out.print("Enter user id :");
		user_id = in.nextInt();

		ResultSet resultSet = api.fetchOrders(user_id, order_status);

		System.out.printf("%10s %15s %20s\n", "User ID", "Order date",
				"Total Amount");
		if (resultSet.next()) {
			System.out.printf("%10d %15s %20.2f",
					resultSet.getInt("shopper_id"),
					resultSet.getDate("order_date"),
					resultSet.getDouble("total"));
		}else{
			System.out.println("User not found");
		}

		api.closeDB();
	}
}
