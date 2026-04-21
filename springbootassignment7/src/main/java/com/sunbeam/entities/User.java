package com.sunbeam.entities;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private String role;
	private Date birth;
	private String addr;
}
