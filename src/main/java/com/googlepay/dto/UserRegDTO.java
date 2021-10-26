package com.googlepay.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegDTO {
	
	@NotEmpty(message = "firstName should not be empty")
	private String firstName;
	@NotEmpty(message = "lastName should not be empty")
	private String lastName;
	@NotEmpty(message = "Please provide a Mobile Number")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Provide valid Mobile Number")
	@Size(max = 10, message = "phone number is of 10 digits")
	private String phone;
	private String comments;
	
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserRegDTO [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", comments="
				+ comments + "]";
	}
	
	
	
	

}
