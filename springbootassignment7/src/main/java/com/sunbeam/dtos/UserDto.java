package com.sunbeam.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
	 private int id;
	 private String name;
	 private String email;
	 private String password;
	 private String role;
	 private Date birth;
	 private String addr;
	 
	 public void setId(int id) {
		    this.id = id;
	 }


}
