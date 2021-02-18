package com.java.DTO;

public class UserDTO {
	String id;
	String pw;
	String userName;
	String phone;
	String email;
	String address;
	
	public UserDTO(String id, String pw, String userName, String phone, String email, String address) {
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getUserName() {
		return userName;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	
}
