package com.googlepay.service;

import javax.validation.Valid;

import com.googlepay.dto.UserRegDTO;

public interface UserService {

	String getBankServicePortNo();

	String userRegistration(UserRegDTO userReg);

	
	//String addUser(@Valid UserRegDTO userRequestDto);

}
