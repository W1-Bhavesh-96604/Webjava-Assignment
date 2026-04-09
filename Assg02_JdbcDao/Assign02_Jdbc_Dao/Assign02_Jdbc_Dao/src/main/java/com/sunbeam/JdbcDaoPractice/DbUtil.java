package com.sunbeam.JdbcDaoPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

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
			System.exit(1);
		}
		
	}
	
	public static Connection connect() throws Exception {
		
		Connection con=DriverManager.getConnection(DB_URL, DB_Name, DB_Pass);
		return con;
	}
	
}
