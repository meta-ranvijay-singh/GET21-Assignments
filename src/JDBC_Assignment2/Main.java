package JDBC_Assignment2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import JDBC_Assignment1.API;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Scanner in = new Scanner(System.in);

		String db_name = "storefront", choice;
		int product_id, no_of_image;
		List<String> images=new ArrayList<String>();
		API api = new API(db_name);

		do {
			System.out.print("Enter product id :");
			product_id = in.nextInt();

			System.out.print("Enter no of images :");
			no_of_image = in.nextInt();

			in.nextLine();
			for (int i = 0; i < no_of_image; ++i) {
				System.out.print("Enter images url " + (i + 1) + " :");
				images.add(in.nextLine());
			}

			api.insertImages(product_id, images);

			System.out.print("Want to enter more(Y/N) :");
			choice = in.nextLine();
		} while ("Y".equals(choice) || "y".equals(choice));


		api.closeDB();

	}

}
