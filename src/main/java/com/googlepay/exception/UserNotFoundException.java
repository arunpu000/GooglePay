package com.googlepay.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	String msg;

	public UserNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public UserNotFoundException() {
		super();
	}
}