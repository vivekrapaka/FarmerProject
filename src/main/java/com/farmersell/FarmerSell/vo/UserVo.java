package com.farmersell.FarmerSell.vo;

import org.antlr.v4.runtime.misc.NotNull;

public class UserVo {
	
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String email;
	
	private String password;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
