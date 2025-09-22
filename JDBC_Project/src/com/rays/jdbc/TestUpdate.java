package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("update employee set name = 'rohit' where name = 'anshul'");
		System.out.println("Data updated succesfully" + i);
	}
	

}
