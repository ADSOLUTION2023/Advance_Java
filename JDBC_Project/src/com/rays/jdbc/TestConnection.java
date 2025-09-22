package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {
	public static void main(String[] args) throws Exception {
		//Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Make Connection to the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		//Create Statement
		Statement stmt = con.createStatement();
		//Execute Query and get ResultSet
		ResultSet rs = stmt.executeQuery("select * from employee");
			
		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t"+ rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.println("\t" + rs.getString(4));
		}
		con.close();
	}

}
