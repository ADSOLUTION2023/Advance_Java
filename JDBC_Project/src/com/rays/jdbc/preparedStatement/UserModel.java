package com.rays.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

	// ----GENERATE NEXT PRIMARY KEY------

	public int nextPk() throws Exception {
		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/employee", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("select max(id) from st_user");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}

		con.close();
		return pk + 1;
	}

	// -----INSERT RECORD-----
	public void add(UserBean bean) throws Exception {
		
		UserBean existBean = findByLogin(bean.getLogin());
		if (existBean != null) {
			 throw new Exception ("Login Id already exist");
		}

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/employee", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?)");

		int pk = nextPk();

		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLogin());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

		int i = pstmt.executeUpdate();
		System.out.println("Record Inserted Successfully: " + i);
		con.close();

	}

	// -------DELETE RECORD----------
	public void delete(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/employee", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("delete from st_user where id =?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Record Deleted Succesfully:" + i);
		con.close();
	}
	// ----UPDATE RECORD-----

	public void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/employee", "root", "root");
		PreparedStatement pstmt = con.prepareStatement(
				"update st_user set firstName = ?,lastName = ?,login = ?, password = ?, dob =? where id = ?");
		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLogin());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Record Updated Succesfully: " + i);

		con.close();

	}
	//------FIND BY LOGIN------

	public UserBean findByLogin(String login) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ?");

		pstmt.setString(1, login);

		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setLogin(rs.getString(4));
		}
		conn.close();
		return bean;
	}
	//------AUTHENTICATE--------
	
	public UserBean authenticate(String login, String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ? and password = ?");
		
		pstmt.setString(1, login);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		UserBean bean = null;
		
		while (rs.next()) {
			
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			
		}
		conn.close();
		return bean;
	}
	
	//-----CHANGE PASSWORD----
	
	public void changePassword (String old_password, String new_password, String login) throws Exception {
		
		UserBean existBean = findByLogin(login);

		System.out.println("Database Password: " + existBean.getPassword());
		System.out.println("Old Password: " + old_password);
		
		if (existBean.getPassword().equals(old_password)) {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		PreparedStatement pstmt = con.prepareStatement("update st_user set password = ? where login =?");
		
		pstmt.setString(1, new_password);
		pstmt.setString(2, login);
		
		int i = pstmt.executeUpdate();
		System.out.println("Password has Changed" + i);
		con.close();
		}else {
		throw new Exception("Wrong old Password");
		}
	}
	//----SEARCH METHOD------
	
	public List search1(UserBean bean) throws Exception {
		
		List list = new ArrayList();
		
		StringBuffer sql = new StringBuffer("select * from st_user");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root","root");
		
		System.out.println("sql-->" + sql.toString());
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()){
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			list.add(bean);
		}
		return list;
	}					
}