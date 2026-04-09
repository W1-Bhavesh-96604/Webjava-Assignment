package com.sunbeam.JdbcDaoPractice;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class JdbcDao {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		try(UserDao userDao =new DaoImpl()){
			
//			System.out.println("Enter Userid");
//			int userId=sc.nextInt();
//			User user=userDao.findById(userId);
//			if(user!=null) {
//				System.out.println("User Found");
//			}else {
//				System.out.println("User Not Found");
//			}
//			
			//call findall
			
//			List<User> list=userDao.findAll();
//			for (User user2 : list) {
//				System.out.println(user2);
//			}
			
			
			//find by email
			
//			System.out.println("Enter Email");
//			String email=sc.nextLine();
//			User user=userDao.findByEmaii(email);
//			if(user!=null) {
//				System.out.println("User Found");
//			}else {
//				System.out.println("User Not Found");
//			}
			
			
			//insert user
					
		//	System.out.print("Enter Name: ");
///		String name = sc.next();
//	System.out.print("Enter Password: ");
//			String password = sc.next();
//			System.out.print("Enter Email: ");
//			String email = sc.next();
//			System.out.print("Enter Address: ");
//			String addr = sc.next();
//			System.out.print("Enter Birth (yyyy-MM-dd): ");
//			String birthStr = sc.next();
//			System.out.print("Enter Role: ");
//			String role = sc.next(); 
//			Date birth = Date.valueOf(birthStr);
//			
//			User user = new User(0, name, email, password, addr, role, birth);
//			int count=userDao.save(user);
//			System.out.println("user inserted" +count );
//			
			
			//update user
			
//			System.out.println("Enter the userid to update");
//			int userId=sc.nextInt();
//			System.out.print("Enter Name: ");
//			String name = sc.next();
//			System.out.print("Enter Email: ");
//			String email = sc.next();
//			System.out.print("Enter Password: ");
//			String password = sc.next();
//			System.out.print("Enter Address: ");
//			String addr = sc.next();
//			System.out.print("Enter Birth (yyyy-MM-dd): ");
//			String birthStr = sc.next();
//			System.out.print("Enter Role: ");
//			String role = sc.next(); 
//			Date birth = Date.valueOf(birthStr);
//			
//			User user = new User(userId, name, email, passwd, addr, role, birth);
//			int count=userDao.update(user);
//			System.out.println("user updated" +count );
			
			
			//change pass
			
//			System.out.println("Enter the userid to change password");
//			int userId=sc.nextInt();
//			System.out.print("Enter Password: ");
//			String password = sc.next();
//			
//			int count=userDao.changePassword(userId, password);
//			System.out.println("Password Changed" +count);
			
			
			//delete user
			
			System.out.println("Enter the userid to Delete");
			int userId=sc.nextInt();
			
			int count = userDao.deleteById(userId);
			System.out.println("User Deleted");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
