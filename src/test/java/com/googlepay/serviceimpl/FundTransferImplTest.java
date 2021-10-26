package com.googlepay.serviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.googlepay.dto.FundTrasfer;
import com.googlepay.entity.TranasactionGooglePayHistory;
import com.googlepay.entity.UserRegistration;
import com.googlepay.feignclient.BankFeignClient;
import com.googlepay.repostory.TransactionGoogleyPayRepo;
import com.googlepay.repostory.UserRepostory;

public class FundTransferImplTest {
	
	@InjectMocks
	FundTransferImpl fundTransferImpl;
	
	@Mock
	BankFeignClient bankFeignClient;

	@Mock
	TransactionGoogleyPayRepo googlePayRepo;
	@Mock
	UserRepostory customerRepository;
	
	static  UserRegistration user=null;
	
	static TranasactionGooglePayHistory fromTransaction=null;
    static FundTrasfer transfer=null;
    
	@BeforeAll
	public static void init(){
		
	    System.out.println("BeforeAll init() method called");
	    fromTransaction =new TranasactionGooglePayHistory ();
	    System.out.println("User fromTransaction object created..");
	    transfer=new FundTrasfer();
	    System.out.println("FundTrasfer DTO object created...");
	    user=new UserRegistration();
}
	
	   // @Test
	  //  public void fundTransfer() {
		
		//transfer.setFromPhoneNumber("7598125419");
		//transfer.setToPhoneNumber("7397368451");
		//transfer.setAmount("2500");
		//transfer.setComments("Debit");
		//transfer.setTransactionId(0);
	   // Mockito.when(bankFeignClient.transferByPhone(transfer)).equals(true);
       // Mockito.when(googlePayRepo.save(fromTransaction)).thenReturn(null);
		//String fundTransferBalance = fundTransferImpl.fundTransferGooglePay(transfer);
		//assertEquals(fundTransferBalance,"successfully Money transfered");

	//}
	    
	        @Test
	        public void transferViaPhone() {
	    	transfer.setFromPhoneNumber("7598125419");
			transfer.setToPhoneNumber("7397368451");
			transfer.setAmount("2500");
			transfer.setComments("Debit");
			transfer.setTransactionId(0);
			Mockito.when(customerRepository.findByPhoneNumber("7598125419")).thenReturn(user);
			Mockito.when(customerRepository.findByPhoneNumber("7397368451")).thenReturn(user);
		    Mockito.when(bankFeignClient.transferByPhone(transfer)).equals(true);
		    String fundTransferBalance = fundTransferImpl.fundTransferGooglePay(transfer);
			assertEquals(fundTransferBalance,"successfully Money transfered");

	    }
	    
	    
	    
	    
	
	//@Test
	//public void transferViaPhone() {
		//transfer.setFromPhoneNumber("7598125419");
		//transfer.setToPhoneNumber("7397368451");
		//transfer.setAmount("2500");
		//transfer.setComments("Debit");
		//transfer.setTransactionId(0);
	//ResponseEntity<String> response=new ResponseEntity<>(HttpStatus.OK);
 //   Mockito.when(bankFeignClient.transferByPhone(transfer)).equals(response);
//response=fundTransferImpl.fundTransferGoogle(transfer);
	     // Mockito.when(bankFeignClient.transferByPhone(transfer)).equals(true);
//assertEquals(response.getStatusCode().is2xxSuccessful(),"successfully Money transfered");

	//}
}
