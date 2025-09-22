package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement stmt = conn.createStatement();
		//Execute insert/delete/update query and get numbers of records affected
		int i = stmt.executeUpdate("insert into employee values(34,'Lucky','ITC',305000),(35,'Rohit','Dell',40500)");
		System.out.println("Data inserted Successfully" + i);
		//int j = stmt.executeUpdate("update employee set id = 21 where id = 34");
		//System.out.println("Data inserted Successfully");
		//int k = stmt.executeUpdate("update employee set id = 22 where id = 32");
		//int l = stmt.executeUpdate("delete from employee where name = 'Lucky'");
		//System.out.println("Data Deleted Successfully" + l);
	}

}
