package com.googlepay.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.googlepay.dto.FundTrasfer;
import com.googlepay.service.FundTransferService;

@RestController
public class FundTransferGooglePayController {

	@Autowired
	FundTransferService service;
	
	/*
	 * @PostMapping("/transerMoney") public String fundTransfer(@RequestBody
	 * FundTrasfer fundTransfer) { String message =
	 * service.fundTransferGooglePay(fundTransfer);
	 * System.out.println("message>>>>>>>>>>>"+message); return message; }
	 */
	
	@PostMapping("/fundTransfer")
	public ResponseEntity<String> fundTransferViaPhone(@Valid @RequestBody FundTrasfer fundTransfer)
	{
	    String response = service.fundTransferGooglePay(fundTransfer);
	    return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	

}
