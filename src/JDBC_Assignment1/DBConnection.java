package JDBC_Assignment1;

import java.sql.*;

//Class for database connection
public class DBConnection {
	private String db_name, db_user, db_password;
	Connection conn;

	// Constructor
	public DBConnection(String db_name) {
		this.db_name = db_name;
		db_user = "root";
		db_password = "123";
	}

	/*
	 * Method to create database connection
	 * 
	 * @return Connection object
	 */
	public Connection getConnections() throws SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		db_user = "root";
		db_password = "123";
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
				+ db_name, db_user, db_password);

		return conn;
	}
}
