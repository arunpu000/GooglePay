package com.googlepay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="userregistration")
public class UserRegistration {
	@Id
	@SequenceGenerator(name = "user_id", sequenceName = "user_sequence", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id")
	//@GenericGenerator(name="native",strategy = "user_id")
	@Column(name = "user_id")
	private int UserId;
	private String firstName;
	private String lastName;
	private String comments;
	private String phoneNumber;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "UserRegistration [UserId=" + UserId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", comments=" + comments + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
