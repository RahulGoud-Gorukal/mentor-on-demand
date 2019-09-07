package com.example.MentorOnDemand.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Column(name="userId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@Column(name="username")
	private String username;
	@Column(name="gender")
	private String gender;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="address")
	private String address;
	@Column(name="contact_number")
	private String contactNumber;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", gender=" + gender + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", contactNumber=" + contactNumber + "]";
	}
	public User(long userId, String username, String gender, String email, String password, String address,
			String contactNumber) {
		super();
		this.userId = userId;
		this.username = username;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contactNumber = contactNumber;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
