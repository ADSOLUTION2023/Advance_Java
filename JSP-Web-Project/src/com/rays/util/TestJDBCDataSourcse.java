package com.rays.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBCDataSourcse {
	public static void main(String[] args) {
		for (int i=0;i<=100;i++) {
			testSearch();
			System.out.println("No. of Connection : " + i);
			
		}
	}
	public static void testSearch() {
		Connection conn =null;
		try {
			conn =JDBCDataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from st_user id =1");
			
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
