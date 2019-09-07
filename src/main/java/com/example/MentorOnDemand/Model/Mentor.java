package com.example.MentorOnDemand.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="mentor")
public class Mentor {
	@Column(name="mentor_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mentorId;
	@Column(name="mentor_name")
	private String mentorName;
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
	@Column(name="technology")
	 private String technology;
	 @Column(name="experience_in_years")
	 private int experience;
	 @Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date date;
	 @Column(name="timeslot")
	 private String timeslot;
	 @Column(name="status")
	 private String status;
	 @Column(name="access")
	 private int access;
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
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
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Mentor [mentorId=" + mentorId + ", mentorName=" + mentorName + ", gender=" + gender + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", technology=" + technology + ", experience=" + experience + ", date=" + date + ", timeslot="
				+ timeslot + ", status=" + status + ", access=" + access + "]";
	}
	public Mentor(int mentorId, String mentorName, String gender, String email, String password, String address,
			String contactNumber, String technology, int experience, Date date, String timeslot, String status,
			int access) {
		super();
		this.mentorId = mentorId;
		this.mentorName = mentorName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contactNumber = contactNumber;
		this.technology = technology;
		this.experience = experience;
		this.date = date;
		this.timeslot = timeslot;
		this.status = status;
		this.access = access;
	}
	public Mentor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
