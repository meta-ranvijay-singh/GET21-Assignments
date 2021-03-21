package JDBC_Assignment3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import JDBC_Assignment1.API;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner in = new Scanner(System.in);

		String db_name = "storefront";
		List<Integer> products=new ArrayList<Integer>();
		API api = new API(db_name);

		ResultSet resultSet = api.getProductIdNotOrderLastYear();
		
		while(resultSet.next()){
			products.add(resultSet.getInt("product_id"));
		}
		
		api.deleteProductBatch(products);
		
		System.out.println("Number of deleted products :"+products.size());

		api.closeDB();


	}

}
