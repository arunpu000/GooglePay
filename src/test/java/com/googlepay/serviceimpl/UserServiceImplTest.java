package com.googlepay.serviceimpl;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.googlepay.dto.UserRegDTO;
import com.googlepay.entity.UserRegistration;
import com.googlepay.feignclient.BankFeignClient;
import com.googlepay.repostory.UserRepostory;

//@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {

	@Mock
	UserRepostory customerRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	BankFeignClient bankFeignClient;	

	
	
	static  UserRegistration user=null;
	static UserRegDTO userRegDTO =null;
	
	@BeforeAll
	public static void init(){
		
	    System.out.println("BeforeAll init() method called");
	    user =new UserRegistration ();
	    System.out.println("User Regestration object created..");
	    userRegDTO=new UserRegDTO();
	    System.out.println("User DTO object created...");
}
	

	@Test
	public void userRegistration() {
		
		Mockito.when(bankFeignClient.PhoneNumberExist("7397368451")).thenReturn(true);
		
		Mockito.when(customerRepository.findByPhoneNumber("7397368451")).thenReturn(null);
		
		//UserRegistration  user =new UserRegistration ();
		//UserRegDTO userRegDTO=new UserRegDTO();
		userRegDTO.setFirstName("Arun");
		userRegDTO.setLastName("Kumar");
		userRegDTO.setPhone("7397368451");
		userRegDTO.setComments("Success");
		Mockito.when(customerRepository.save(user)).thenReturn(null);
		
		String googlePayRegistration = userServiceImpl.userRegistration(userRegDTO);
		System.out.println(googlePayRegistration);
		assertEquals(googlePayRegistration,"Sucessfully register with google pay account");
	}
}
