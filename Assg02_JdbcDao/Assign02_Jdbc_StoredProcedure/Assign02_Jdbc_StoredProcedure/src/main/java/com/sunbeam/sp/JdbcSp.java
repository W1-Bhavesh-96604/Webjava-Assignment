package com.sunbeam.sp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcSp {
	
public static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	
	public static final String DB_URL="jdbc:mysql://localhost:3306/advjava";
	
	public static final String DB_Name="Advjava";
	
	public static final String DB_Pass="Advjava";
	
	static {
		
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		
try(Connection con = DriverManager.getConnection(DB_URL, DB_Name, DB_Pass)) {
            
            
            String sql = "CALL sp_users_by_role()";
            try(CallableStatement stmt = con.prepareCall(sql)) {
                
            
                boolean isRS = stmt.execute();
                
                if(isRS) {
                    
                    try(ResultSet rs = stmt.getResultSet()) {
                        while(rs.next()) {
                            String role = rs.getString("role");
                            int count = rs.getInt("cnt");
                            
                            System.out.printf("%s, %d\n", role, count);
                        }
                    } 
                }
                else {
                    
                    int count = stmt.getUpdateCount();
                    System.out.println("Affected Rows: " + count);
                }
            } 
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

	}

}
