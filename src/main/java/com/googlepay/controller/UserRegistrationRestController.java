package com.googlepay.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googlepay.dto.UserRegDTO;
import com.googlepay.service.UserService;

@RestController
@RequestMapping("/googlepay")
public class UserRegistrationRestController {

	@Autowired
	UserService userService;
	
	@GetMapping("/port")
	public String getBankServicePortNo() {
		return userService.getBankServicePortNo();
	}
	
    @PostMapping("/userRegistration")
	public String userRegistration(@Valid @RequestBody UserRegDTO userReg) {
    	
		String registration=userService.userRegistration(userReg);
		
		return registration;
	}
	
  
}
