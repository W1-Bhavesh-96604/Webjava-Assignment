package com.sunbeam.JdbcDaoPractice;

import java.sql.Date;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	private String addr;
	private String role;
	private Date birth;
	
	public User() {
		
	}

	
	public User(int id, String name, String email, String password, String addr, String role, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.addr = addr;
		this.role = role;
		this.birth = birth;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", addr=" + addr
				+ ", role=" + role + ", birth=" + birth + "]";
	}
	
	
	
}
