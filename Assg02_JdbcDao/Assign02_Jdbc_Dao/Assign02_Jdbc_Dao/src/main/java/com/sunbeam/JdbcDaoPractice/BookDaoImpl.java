package com.sunbeam.JdbcDaoPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao,AutoCloseable{

	private Connection con;
	
	public BookDaoImpl() throws Exception {
		con=DbUtil.connect();
	}
	
	@Override
	public void close() throws Exception {
		
		if(con !=null)
			con.close();
	}

	@Override
	public Book findById(int bookId) throws Exception {
		
		String sql = "SELECT * FROM book WHERE id=?";
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			
			ps.setInt(1, bookId);
			
			try(ResultSet rs = ps.executeQuery()){
				
				if(rs.next()) {
					
					String name=rs.getString("name");
					String author=rs.getString("author");
					String subject=rs.getString("subject");
					double price=rs.getDouble("price");
					
					Book book=new Book(bookId, name, author, subject, price);
					return book;
				}
			}
		}
		
		return null;
	}

	@Override
	public List<Book> findAll() throws Exception {
		
		String sql ="SELECT * FROM book";
		List<Book> bookList = new ArrayList<>();
		try(PreparedStatement ps=con.prepareStatement(sql)){
			
			try(ResultSet rs=ps.executeQuery()){
				
				while(rs.next()) {
					
					int id=rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price= rs.getDouble("price");
					
					Book book = new Book(id, name, author, subject, price);
					bookList.add(book);
				}
			}
		}
		return bookList;
	}

	@Override
	public List<Book> findByNameLike(String name) throws Exception {
		
		String sql="SELECT * FROM book WHERE name like ?";
		List<Book> bookList = new ArrayList<>();
		try(PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, "%" + name + "%");
			try(ResultSet rs=ps.executeQuery()){
				
				while(rs.next()) {
					
					int id=rs.getInt("id");
					String bookname=rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price= rs.getDouble("price");
					
					Book book = new Book(id, bookname, author, subject, price);
					bookList.add(book);
				}
			}
		}
		return bookList;
	}

	@Override
	public List<Book> findByAuthor(String author) throws Exception {
		
		String sql="SELECT * FROM book WHERE author=?";
		List<Book> bookList = new ArrayList<>();
		try(PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, author);
			try(ResultSet rs=ps.executeQuery()){
				
				while(rs.next()) {
					
					int id=rs.getInt("id");
					String bookname=rs.getString("name");
					
					String subject = rs.getString("subject");
					double price= rs.getDouble("price");
					
					Book book = new Book(id, bookname, author, subject, price);
					bookList.add(book);
				}
			}
		}
		
		return bookList;
	}

	@Override
	public List<Book> findBySubject(String subject) throws Exception {
		
		String sql="SELECT * FROM book WHERE subject=?";
		List<Book> bookList = new ArrayList<>();
		try(PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, subject);
			try(ResultSet rs=ps.executeQuery()){
				
				while(rs.next()) {
					
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String email = rs.getString("author");
					String password = rs.getString("subject");
					double price= rs.getDouble("price");
					
					Book book = new Book(id, name, email, password, price);
					bookList.add(book);
				}
			}
		}
		return bookList;
	}

	@Override
	public List<Book> findByPriceBetween(double minPrice, double maxPrice) throws Exception {
		
		String sql="SELECT * FROM book WHERE price BETWEEN ? and ?";
		List<Book> bookList = new ArrayList<>();
		try(PreparedStatement ps=con.prepareStatement(sql)){
			ps.setDouble(1, minPrice);
			ps.setDouble(2, maxPrice);
			try(ResultSet rs=ps.executeQuery()){
				
				while(rs.next()) {
					
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String email = rs.getString("author");
					String password = rs.getString("subject");
					double price= rs.getDouble("price");
					
					Book book = new Book(id, name, email, password, price);
					bookList.add(book);
				}
			}
		}
		return bookList;
	}

	@Override
	public int save(Book b) throws Exception {
		
String sql = "INSERT INTO book (name,author,subject,price) VALUES (?,?,?,?)";
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getSubject());
			ps.setDouble(4, b.getPrice());
			
			
			
			int count=ps.executeUpdate();
			return count;
			
		}
		
		
	}

	@Override
	public int update(Book b) throws Exception {
		
		String sql ="UPDATE book SET name=?,author=?,subject=?,price=? WHERE id=?";
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getSubject());
			ps.setDouble(4, b.getPrice());
			ps.setInt(5, b.getId());
			
			
			int count=ps.executeUpdate();
			return count;
			
		}
		
	}

	@Override
	public int deleteById(int bookId) throws Exception {
		
		String sql ="DELETE FROM book WHERE id=?";
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			
			ps.setInt(1, bookId);
			
			return ps.executeUpdate();
		}
		
		
	}

}
