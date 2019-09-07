package com.example.MentorOnDemand.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Column(name="adminId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	@Column(name="admin_name")
	private String adminName;
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
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", gender=" + gender + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", contactNumber=" + contactNumber + "]";
	}
	public Admin(long adminId, String adminName, String gender, String email, String password, String address,
			String contactNumber) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contactNumber = contactNumber;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
