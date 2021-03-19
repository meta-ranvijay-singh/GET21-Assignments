package JDBC_Assignment1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class API {
	private ResultSet resultSet;
	Statement statement;
	PreparedStatement prepareStmt;
	Connection conn;
	DBConnection connection;
	
	public API(String db_name){
		connection=new DBConnection(db_name);
	}
	
	public ResultSet fetchOrders(int user_id, String orderStatus) throws ClassNotFoundException, SQLException{
		conn=connection.getConnections();
		String querry="SELECT s.shopper_id, o.order_date, SUM(unit_price*quantity) AS total "
				+ "FROM shopper s INNER JOIN orders o ON o.shopper_id = s.shopper_id "
				+ "INNER JOIN items i ON i.order_id = o.order_id "
				+ "WHERE o.shopper_id= ? AND o.order_status = ?"
				+ " GROUP BY o.shopper_id";
		
		prepareStmt=conn.prepareStatement(querry);
		
		prepareStmt.setInt(1, user_id);
		prepareStmt.setString(2, orderStatus);
		
		resultSet=prepareStmt.executeQuery();
		
		return resultSet;
	}
	
	public void insertImages(int productId, List<String> images) throws ClassNotFoundException, SQLException{
		conn=connection.getConnections();
		
		String query ="INSERT INTO images (product_id, image) VALUES(?, ?)";
		
		prepareStmt = conn.prepareStatement(query);
		
		for(int i=0; i<images.size(); ++i){
			prepareStmt.setInt(1, productId);
			prepareStmt.setString(2, images.get(0));
			
			prepareStmt.addBatch();
		}
		
		prepareStmt.executeBatch();
	}
	
	public ResultSet getProductIdNotOrderLastYear() throws SQLException, ClassNotFoundException{
		conn=connection.getConnections();
		
		String querry="SELECT product_id "
				+ "FROM product WHERE product_id NOT IN ( "
				+ "SELECT i.product_id FROM orders o "
				+ "INNER JOIN items i ON o.order_id =  i.order_id "
				+ "WHERE DATE(order_date) > DATE_SUB(CURDATE(), INTERVAL 1 YEAR) "
				+ "GROUP BY i.product_id)";
		statement=conn.createStatement();
		
		resultSet=statement.executeQuery(querry);
		
		return resultSet;
		
	}
	
	public void deleteProductBatch(List<Integer> products) throws ClassNotFoundException, SQLException{
		conn=connection.getConnections();
		
		String querry="DELETE FROM product WHERE product_id=?";
		prepareStmt=conn.prepareStatement(querry);
		
		for(int i=0; i<products.size(); ++i){
			prepareStmt.setInt(1, products.get(i));
			prepareStmt.addBatch();
		}
		
		prepareStmt.executeBatch();
	}
	
	public void closeDB() throws SQLException{
		conn.close();
	}
	

}
