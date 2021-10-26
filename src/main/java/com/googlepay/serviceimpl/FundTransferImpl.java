package com.googlepay.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlepay.dto.FundTrasfer;
import com.googlepay.dto.UserRegDTO;
import com.googlepay.entity.TranasactionGooglePayHistory;
import com.googlepay.entity.UserRegistration;
import com.googlepay.exception.UserDefinedException;
import com.googlepay.feignclient.BankFeignClient;
import com.googlepay.repostory.TransactionGoogleyPayRepo;
import com.googlepay.repostory.UserRepostory;
import com.googlepay.service.FundTransferService;

@Service
@Transactional

public class FundTransferImpl implements FundTransferService {
	
	@Autowired
	BankFeignClient bankFeignClient;

	@Autowired
	TransactionGoogleyPayRepo googlePayRepo;

	  @Autowired 
	  UserRepostory userRepository;
	 
	
	@Override
	public String fundTransferGooglePay(FundTrasfer fundTransfer)throws UserDefinedException {
		Boolean result = false;
		
		String amount=fundTransfer.getAmount();
		
		System.out.println("Amount>>>>>>>>>"+ amount);
		
		String toPhoneNumber=fundTransfer.getToPhoneNumber();
		
		String fromPhoneNumber=fundTransfer.getFromPhoneNumber();
		ResponseEntity<Boolean> fundTransferPhoneNumber = bankFeignClient.transferByPhone(fundTransfer);
		if(fundTransferPhoneNumber.equals("true")) {
			TranasactionGooglePayHistory fromTransaction=new TranasactionGooglePayHistory();
		    BeanUtils.copyProperties(fundTransfer, fromTransaction);
			googlePayRepo.save(fromTransaction);
			fundTransfer.setAmount(amount);
			TranasactionGooglePayHistory totransaction=new TranasactionGooglePayHistory();
			BeanUtils.copyProperties(fundTransfer, totransaction);
			googlePayRepo.save(totransaction);
			 result = true;
		}
		
		
		{
	         return "successfully Money transfered";
	}
		
	}
	
	public ResponseEntity<String> fundTransferGoogle(FundTrasfer fundTransfer)throws UserDefinedException {
		Boolean result = false;
		
		String amount=fundTransfer.getAmount();
		
		System.out.println("Amount>>>>>>>>>"+ amount);
		
		String toPhoneNumber=fundTransfer.getToPhoneNumber();
		
		String fromPhoneNumber=fundTransfer.getFromPhoneNumber();
		ResponseEntity<Boolean> fundTransferPhoneNumber = bankFeignClient.transferByPhone(fundTransfer);
		if(fundTransferPhoneNumber.equals("true")) {
			TranasactionGooglePayHistory fromTransaction=new TranasactionGooglePayHistory();
		    BeanUtils.copyProperties(fundTransfer, fromTransaction);
			googlePayRepo.save(fromTransaction);
			fundTransfer.setAmount(amount);
			TranasactionGooglePayHistory totransaction=new TranasactionGooglePayHistory();
			BeanUtils.copyProperties(fundTransfer, totransaction);
			googlePayRepo.save(totransaction);
			 result = true;
		}
		
		
		{
	         return  new ResponseEntity<String>(HttpStatus.OK);
	}
		
	}
	
	}
	
