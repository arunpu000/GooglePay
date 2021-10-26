package com.googlepay.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class GooglePayHistoryDTO {

	private int tranID;
	@NotEmpty(message = "Please provide a Mobile Number")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Provide valid Mobile Number")
	@Size(max = 10, message = "phone number is of 10 digits")
	private String toPhoneNumber;
	private String fromPhoneNumber;
	private String amount;
	private String remarks;
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getTranID() {
		return tranID;
	}
	public void setTranID(int tranID) {
		this.tranID = tranID;
	}
	public String getToPhoneNumber() {
		return toPhoneNumber;
	}
	public void setToPhoneNumber(String toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}
	public String getFromPhoneNumber() {
		return fromPhoneNumber;
	}
	public void setFromPhoneNumber(String fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
