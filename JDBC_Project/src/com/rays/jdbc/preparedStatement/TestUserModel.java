package com.rays.jdbc.preparedStatement;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testDelete();
		//testUpdate();
		//findByLogin();
		//authenticate();
		changePassword();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setFirstName("Amit");
		bean.setLastName("Chandsarkar");
		bean.setLogin("amit@gmail.com");
		bean.setPassword("amit123");
		bean.setDob(sdf.parse("1986-10-19"));

		model.add(bean);

	}
	
	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		bean.setId(2);
		model.delete(bean);
	}
	
	public static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setFirstName("Raj");
		bean.setLastName("Aryan");
		bean.setLogin("Raj123");
		bean.setPassword("12345");
		bean.setDob(sdf.parse("1998-10-02"));
		bean.setId(3);
		
		model.update(bean);
	}
	
	public static void findByLogin() throws Exception {
		UserModel model = new UserModel();
		UserBean existBean = model.findByLogin("Raj123");
		
		if (existBean != null) {
			System.out.println("Login Id already Exist");
		}else {
			System.out.println("No Record Found");
		}
		
	}
	
	public static void authenticate () throws Exception {
		UserModel model = new UserModel();
		UserBean existBean= model.authenticate("Raj123","12345");
		
		if (existBean != null) {
			System.out.println("Login Id and Password alreay Exist");
		}else {
			System.out.println("No record found");
		}
	}
	
	public static void changePassword() throws Exception {
		
		UserModel model = new UserModel();
		
		model.changePassword("amit123","123Amit","amit@gmail.com");
	}
	
	public static void search () {
		
		UserModel model = new UserModel();
		
		List list = model.search1(null);
		
		Iterable<UserBean> it = list.iterator();
		
		while (it.hasNext()) {
		
		
	}
}
