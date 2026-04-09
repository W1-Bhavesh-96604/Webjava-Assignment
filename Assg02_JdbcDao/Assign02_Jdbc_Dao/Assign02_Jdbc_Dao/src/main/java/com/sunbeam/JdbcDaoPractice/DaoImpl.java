package com.sunbeam.JdbcDaoPractice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements UserDao,AutoCloseable {

	private Connection con;
	
	public DaoImpl() throws Exception {
		
		con=DbUtil.connect();
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(con !=null)
			con.close();
	}

	@Override
	public User findById(int userId) throws Exception {
		
		String sql ="SELECT * FROM users WHERE id=?";
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, userId);
		
			try(ResultSet rs=ps.executeQuery()){
				if(rs.next()) {
					
					String name=rs.getString("name");
					String email=rs.getString("email");
					String password=rs.getString("password");
					String addr=rs.getString("addr");
					String role=rs.getString("role");
					Date birth=rs.getDate("birth");
					
					User user =new User(userId,name,email,password,addr,role,birth);
					
					return user;
					
				}
				
				
			}
		}
		return null;
	}

	@Override
	public List<User> findAll() throws Exception {
		
		String sql ="SELECT * FROM users";
		List<User> userList=new ArrayList<>();
		try(PreparedStatement ps=con.prepareStatement(sql)){
			
			try(ResultSet rs=ps.executeQuery()){
				
				while(rs.next()) {
					int id=rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String password = rs.getString("password");
					String role = rs.getString("role");
					String addr = rs.getString("addr");
					Date birth = rs.getDate("birth");
					
					User user=new User(id, name, email, password, addr, role, birth);
					userList.add(user);
				}
			}
		}
		
		return userList;
	}

	@Override
	public User findByEmaii(String email) throws Exception {
		
		String sql="SELECT * FROM users WHERE email=?";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1,email);
			try(ResultSet rs=ps.executeQuery()){
				if(rs.next()) {
				int userId = rs.getInt("id");
				String name = rs.getString("name");
				
				String password = rs.getString("password");
				String role = rs.getString("role");
				String addr = rs.getString("addr");
				Date birth = rs.getDate("birth");
					
				User user=new User(userId, name, email, password, addr, role, birth);
				return user;
			}
			
		}
		
		
	}
		return null;

	}

	@Override
	public int save(User user) throws Exception {
		
		String sql = "INSERT INTO users (name,email,password,addr,role,birth) VALUES (?,?,?,?,?,?)";
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAddr());
			ps.setString(5, user.getRole());
			ps.setDate(6, user.getBirth());
			int count=ps.executeUpdate();
			return count;
			
		}
		
		
	}

	@Override
	public int update(User user) throws Exception {
		
		String sql ="UPDATE users SET name=?,email=?,password=?,addr=?,role=?,birth=? WHERE id=?";
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAddr());
			ps.setString(5, user.getRole());
			ps.setDate(6, user.getBirth());
			ps.setInt(7, user.getId());
			
			int count=ps.executeUpdate();
			return count;
		}
		
	}

	@Override
	public int changePassword(int userId, String password) throws Exception {
		
		String sql ="UPDATE users SET password=? WHERE id=?";
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			
			ps.setString(1, password);
			ps.setInt(2, userId);
			
			return ps.executeUpdate();
			
		}
		
	}

	@Override
	public int deleteById(int userId) throws Exception {
		
		String sql ="DELETE FROM users WHERE id=?";
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			
			ps.setInt(1, userId);
			
			return ps.executeUpdate();
		}
		
	}

	
	
	
	
	
}
