package com.googlepay.feignclient;


import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.googlepay.dto.FundTrasfer;


@FeignClient(value = "bank", url = "http://localhost:7076")

public interface BankFeignClient {

	
	@GetMapping("/customersBanking/port")
	public String getPortNo();
	
	
	  @GetMapping("/customersBanking/phoneExist/{phoneNumber}") 
	  public boolean PhoneNumberExist(@PathVariable String phoneNumber);
	
	  
	    @PostMapping("/transactionsBanking/transferPhone")
	    public  ResponseEntity<Boolean> transferByPhone( @RequestBody FundTrasfer fundDTO);
}
