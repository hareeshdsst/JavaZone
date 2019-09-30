package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://127.0.0.1:3306/employees_database?serverTimezone=UTC";
		//Establish connection object.
		Connection conn =  DriverManager.getConnection(url, "root","143harish");
		//Create a statement object to send to database.
		Statement statement = conn.createStatement();
		//Execute the statement object
		ResultSet result = statement.executeQuery("select * from employees_tbl");
		//Process the result
		//Record by record
		while(result.next()) {
			System.out.println(result.getString("name"));
		}
	}
}
