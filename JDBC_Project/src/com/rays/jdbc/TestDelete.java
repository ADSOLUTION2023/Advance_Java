package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement stmt = con.createStatement();
		int i = stmt.executeUpdate("delete from employee where name = 'Amit'");
		System.out.println("Data Deleted Sucessfully"+i);
		
	}

}
