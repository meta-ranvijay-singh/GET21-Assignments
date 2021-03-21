package JDBC_Assignment4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC_Assignment1.API;

//Category class
class Category {
	private String category_name;
	private int category_id, no_of_child;

	// Constructor
	public Category(int id, String name, int num) {
		category_id = id;
		category_name = name;
		no_of_child = num;
	}

	// Method to display details
	public void display() {
		System.out.println("Category ID :" + category_id);
		System.out.println("Category Name :" + category_name);
		System.out.println("No of child category :" + no_of_child);
		System.out.println();
	}
}

public class Main {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		List<Category> categories = new ArrayList<Category>();
		String db_name = "storefront";

		API api = new API(db_name);

		ResultSet resultSet = api.fetchNoOfChildCategories();

		while (resultSet.next()) {
			categories.add(new Category(resultSet.getInt("category_id"),
					resultSet.getString("category_name"), resultSet
							.getInt("childCategory")));
		}

		for (Category category : categories) {
			category.display();
		}

	}

}
