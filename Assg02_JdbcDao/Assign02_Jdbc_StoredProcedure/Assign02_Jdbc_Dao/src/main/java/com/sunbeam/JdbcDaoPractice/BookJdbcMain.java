package com.sunbeam.JdbcDaoPractice;

import java.util.List;
import java.util.Scanner;

public class BookJdbcMain {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		try(BookDao bookDao=new BookDaoImpl()){
			
//			System.out.println("Enter Bookid");
//			int bookId=sc.nextInt();
//			Book book=bookDao.findById(bookId);
//			if(book!=null) {
//				System.out.println("Book Found");
//			}else {
//				System.out.println("Book Not Found");
//			}
			
			
			//find all books
//			List<Book> books=bookDao.findAll();
//			for (Book book : books) {
//				System.out.println(book);
//			}
//			
			
			
			//find by name like
//			System.out.println("Enter Book name");
//			String name=sc.nextLine();
//			List<Book> books=bookDao.findByNameLike(name);
//			for (Book book : books) {
//				System.out.println(book);
//			}
			
			//find author
//			System.out.println("Enter Author");
//			String author=sc.nextLine();
//			List<Book> books=bookDao.findByAuthor(author);
//			for (Book book : books) {
//				System.out.println(book);
//			}
			
			//find subject
//			System.out.println("Enter Subject");
//			String subject=sc.nextLine();
//			List<Book> books=bookDao.findBySubject(subject);
//			for (Book book : books) {
//				System.out.println(book);
//			}
			
			//find price between
			
//			System.out.println("Enter First Price");
//			double price1=sc.nextDouble();
//			System.out.println("Enter Second Price");
//			double price2=sc.nextDouble();
//			List<Book> books=bookDao.findByPriceBetween(price1, price2);
//			for (Book book : books) {
//				System.out.println(book);
//			}
			
			//insert book
			
//			System.out.println("Enter Book name");
//			String name=sc.next();
//			System.out.println("Enter Author");
//			String author=sc.next();
//			System.out.println("Enter Subject");
//			String subject=sc.next();
//			System.out.println("Enter Price");
//			double price=sc.nextDouble();
//			
//			
//			Book book = new Book(0, name, author, subject, price);
//			int count=bookDao.save(book);
//			System.out.println("Book inserted" +count );
			
			
			//update by id
			
//			System.out.println("Enter Book id to update");
//			int id=sc.nextInt();
//			System.out.println("Enter Book name");
//			String name=sc.next();
//			System.out.println("Enter Author");
//			String author=sc.next();
//			System.out.println("Enter Subject");
//			String subject=sc.next();
//			System.out.println("Enter Price");
//			double price=sc.nextDouble();
//			
//			
//			Book book = new Book(id, name, author, subject, price);
//			int count=bookDao.update(book);
//			System.out.println("Book updated" +count );
			
			
			//Delete by id
			System.out.println("Enter the Bookid to Delete");
			int id=sc.nextInt();
			
			int count = bookDao.deleteById(id);
			System.out.println("User Deleted" +count);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
