package JDBC_Assignment1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import JDBC_Assignment2.Images;

//API class for SQL queries
public class API {
	private ResultSet resultSet;
	Statement statement;
	PreparedStatement prepareStmt;
	Connection conn;
	DBConnection connection;

	// Constructor for creating connection
	public API(String db_name) {
		connection = new DBConnection(db_name);
	}

	/*
	 * Method to fetch shipped/not shipped orders details of a specific user
	 * 
	 * @param user_id and order_status
	 * 
	 * @return ResultSet fetched from database
	 */
	public ResultSet fetchOrders(int user_id, String orderStatus)
			throws ClassNotFoundException, SQLException {
		conn = connection.getConnections();
		String querry = "SELECT o.order_date, SUM(unit_price*quantity) AS total "
				+ "FROM items i INNER JOIN orders o ON o.order_id = i.order_id "
				+ "WHERE o.shopper_id = ? AND o.order_status = ?"
				+ " GROUP BY i.order_id";

		prepareStmt = conn.prepareStatement(querry);

		prepareStmt.setInt(1, user_id);
		prepareStmt.setString(2, orderStatus);

		resultSet = prepareStmt.executeQuery();

		return resultSet;
	}

	/*
	 * Method to insert images of a product using batch execution
	 * 
	 * @param productid and list of image url
	 */
	public boolean insertImages(List<Images> images)
			throws ClassNotFoundException, SQLException {
		conn = connection.getConnections();

		String query = "INSERT INTO images (product_id, image) VALUES(?, ?)";

		prepareStmt = conn.prepareStatement(query);

		for (Images image : images) {
			List<String> imageUrl = image.getImageUrl();
			for (int i = 0; i < imageUrl.size(); ++i) {
				prepareStmt.setInt(1, image.getProductId());
				prepareStmt.setString(2, imageUrl.get(i));

				prepareStmt.addBatch();
			}
		}

		prepareStmt.executeBatch();
		return true;
	}

	/*
	 * Method to fetch list of productId which are not ordered since last year
	 * 
	 * @return ResultSet fetched from database
	 */
	public ResultSet getProductIdNotOrderLastYear() throws SQLException,
			ClassNotFoundException {
		conn = connection.getConnections();

		String querry = "SELECT product_id "
				+ "FROM product WHERE product_id NOT IN ( "
				+ "SELECT i.product_id FROM orders o "
				+ "INNER JOIN items i ON o.order_id =  i.order_id "
				+ "WHERE DATE(order_date) > DATE_SUB(CURDATE(), INTERVAL 1 YEAR) "
				+ "GROUP BY i.product_id)";
		statement = conn.createStatement();

		resultSet = statement.executeQuery(querry);

		return resultSet;

	}

	/*
	 * Method to delete list of product from database
	 * 
	 * @param list of product ID to delete
	 */
	public void deleteProductBatch(List<Integer> products)
			throws ClassNotFoundException, SQLException {
		conn = connection.getConnections();

		String querry = "DELETE FROM product WHERE product_id=?";
		prepareStmt = conn.prepareStatement(querry);

		for (int i = 0; i < products.size(); ++i) {
			prepareStmt.setInt(1, products.get(i));
			prepareStmt.addBatch();
		}

		prepareStmt.executeBatch();
	}

	/*
	 * Method to get number of child category of parent category
	 * 
	 * @return ResultSet fetched from database
	 */
	public ResultSet fetchNoOfChildCategories() throws ClassNotFoundException,
			SQLException {
		conn = connection.getConnections();
		String querry = "SELECT c.category_id, c.category_name, COUNT(sc.category_id) AS childCategory "
				+ "FROM subcategory sc INNER JOIN category c "
				+ "ON c.category_id = sc.category_id "
				+ "GROUP BY sc.category_id ORDER BY c.category_name";
		statement = conn.createStatement();
		resultSet = statement.executeQuery(querry);

		return resultSet;
	}

	// Method to close database connection
	public void closeDB() throws SQLException {
		conn.close();
	}

}
