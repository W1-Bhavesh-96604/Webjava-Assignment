package com.sunbeam.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Jdbc_Crud {

	public static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	
	public static final String DB_URL="jdbc:mysql://localhost:3306/advjava";
	
	public static final String DB_Name="Advjava";
	
	public static final String DB_Pass="Advjava";
	
	static {
		
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n ///////////////// USER MENU //////////////");
            System.out.println("1. Display All Users");
            System.out.println("2. Insert New User");
            System.out.println("3. Change Password");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayUsers();
                    break;
                case 2:
                    insertUser(sc);
                    break;
                case 3:
                    changePassword(sc);
                    break;
                case 4:
                    deleteUser(sc);
                    break;
                case 5:
                    System.out.println("End");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    
    public static void displayUsers() {
       try(Connection con =DriverManager.getConnection(DB_URL, DB_Name, DB_Pass)){
    	   
    	   String sql="SELECT * FROM USERS";
    	   System.out.println("Sql :"+sql);
    	   
    	   try(PreparedStatement ps=con.prepareStatement(sql)){
    		   
    		   try(ResultSet rs=ps.executeQuery()){
    			   
    			   while(rs.next()) {
    				   
    				   System.out.println(
    	                        rs.getInt("id") + " " +
    	                        rs.getString("name") + " " +
    	                        rs.getString("email") + " " +
    	                        rs.getString("password") + " " +
    	                        rs.getString("addr") + " " +
    	                        rs.getString("role") + " " +
    	                        rs.getDate("birth")
    	                );
    			   }
    		   }
    	   }
    	   
    	   
       }catch (Exception e) {
		e.printStackTrace();
	}
    }

    
    public static void insertUser(Scanner sc) {

try(Connection con=DriverManager.getConnection(DB_URL, DB_Name, DB_Pass)){
			
			String sql="INSERT INTO USERS(name,email,password,addr,role,birth) values(?,?,?,?,?,?)";
			System.out.println("Sql :"+sql);
			try(PreparedStatement ps=con.prepareStatement(sql)){
				
				System.out.print("Enter Name: ");
				String name = sc.next();
				
				System.out.print("Enter Email: ");
				String email = sc.next();
				System.out.print("Enter Passwd: ");
				String password = sc.next();
				System.out.print("Enter Address: ");
				String addr = sc.next();
				
				System.out.print("Enter Role: ");
				String role = sc.next();
				System.out.print("Enter Birth (yyyy-MM-dd): ");
				String birth = sc.next();
				
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, password);
				ps.setString(4, addr);
				ps.setString(5, role);
				ps.setString(6, birth);
				
				int count=ps.executeUpdate();
				System.out.println("Row "+count);
				
			}
			
					
		}
		catch (Exception e) {
			
			e.printStackTrace();
		
		}
    	
    }

    
    public static void changePassword(Scanner sc) {
    	
    	try(Connection con=DriverManager.getConnection(DB_URL,DB_Name,DB_Pass)){
    		
    		String sql="UPDATE users set password = ? where id = ?";
     	   System.out.println("Sql :"+sql);
     	   
     	   try(PreparedStatement ps=con.prepareStatement(sql)){
     		   
     		  System.out.print("Enter user ID: ");
              int id = sc.nextInt();

              System.out.print("Enter new password: ");
              String password = sc.next();

              ps.setString(1, password);
              ps.setInt(2, id);

              int count = ps.executeUpdate();
              System.out.println(count + " user updated!");
     	   }
    		
    		
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
            }

    
    public static void deleteUser(Scanner sc) {
        
    	try(Connection con=DriverManager.getConnection(DB_URL, DB_Name, DB_Pass)){
    		
    		String sql="DELETE from users where id = ?";
      	   System.out.println("Sql :"+sql);
      	   
      	   try(PreparedStatement ps=con.prepareStatement(sql)){
      		   
      		 System.out.print("Enter user ID to delete: ");
             int id = sc.nextInt();

             ps.setInt(1, id);

             int count = ps.executeUpdate();
             System.out.println(count + " user deleted!");
      	   }
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
}


//public static void displayUsers() {
//	
//	try(Connection con=DriverManager.getConnection(DB_URL, DB_Name, DB_Pass)){
//		
//		String sql="SELECT * FROM USERS "
//		
//		
//	}catch (Exception e) {
//		e.printStackTrace();
//	}
//	
//}
//
//public static void insertUser(Scanner sc) {
//	
//	
//}
//
//public static void changePassword(Scanner sc) {
//	
//}
//
//
//public static void deleteUser(Scanner sc) {
//	
//	
//}


