package com.googlepay.serviceimpl;


import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.googlepay.dto.UserRegDTO;
import com.googlepay.entity.UserRegistration;
import com.googlepay.feignclient.BankFeignClient;
import com.googlepay.repostory.UserRepostory;
import com.googlepay.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	BankFeignClient bankFeignClient;	
	
	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;
	
	
	  @Autowired 
	  UserRepostory userRepository;
	 

	@Autowired
	Environment environment;
	
	
	
	
	@Override
	public String getBankServicePortNo() {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		System.out.println("Bank Port Number"+bankFeignClient.getPortNo());
		return circuitBreaker.run(() -> bankFeignClient.getPortNo(), throwable -> getBankDefaultInfo());
	}

	public String getBankDefaultInfo() {
		return "Bank-service is down, Please try after some time.";
	}

	@Override
	public String userRegistration(UserRegDTO userReg) {

		boolean phoneNoExist=bankFeignClient.PhoneNumberExist(userReg.getPhone());
		System.out.println("phone number>>>>>>>>>>>>"+bankFeignClient.PhoneNumberExist(userReg.getPhone()));
		System.out.println("phone number"+phoneNoExist);
		if(phoneNoExist) {
		UserRegistration reg=new UserRegistration();
		
		BeanUtils.copyProperties(userReg, reg);
		UserRegistration registration=userRepository.findByPhoneNumber(userReg.getPhone());
		System.out.println("phone number>>>>"+ registration);
		reg.setPhoneNumber(userReg.getPhone());
		if(registration!=null) {
			return "Phone number already registered.";
		}
		else {
			userRepository.save(reg);
		}
		}
		return "Sucessfully register with google pay account";
	}

	
	
}
