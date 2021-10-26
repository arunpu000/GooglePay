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
@Table(name="history")
public class TranasactionGooglePayHistory {
@Id
@SequenceGenerator(name = "transactionId", sequenceName = "user_sequence", initialValue = 100, allocationSize = 1)
@GeneratedValue(strategy = GenerationType.AUTO, generator = "transactionId")
	@Column(name = "transactionId")
	private int transactionId;
	private String toPhoneNumber;
	private String fromPhoneNumber;
	private String amount;
	private String remarks;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getToPhoneNumber() {
		return toPhoneNumber;
	}
	public void setToPhoneNumber(String toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}
	public String getFromPhoneNumberNumber() {
		return fromPhoneNumber;
	}
	public void setFromPhoneNumberNumber(String fromPhoneNumberNumber) {
		this.fromPhoneNumber = fromPhoneNumberNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "TranasactionGooglePayHistory [transactionId=" + transactionId + ", toPhoneNumber=" + toPhoneNumber
				+ ", fromPhoneNumberNumber=" + fromPhoneNumber + ", amount=" + amount + ", remarks=" + remarks
				+ "]";
	}
	
	
}
