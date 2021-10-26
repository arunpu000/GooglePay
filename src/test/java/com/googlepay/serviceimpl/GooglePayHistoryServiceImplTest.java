package com.googlepay.serviceimpl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.googlepay.dto.GooglePayHistoryDTO;
import com.googlepay.entity.TranasactionGooglePayHistory;
import com.googlepay.repostory.TransactionGoogleyPayRepo;

public class GooglePayHistoryServiceImplTest {
	
	@Mock
	TransactionGoogleyPayRepo googlePayRepo;
	
	@InjectMocks
	GooglePayHistoryServiceImpl history;
	
	static GooglePayHistoryDTO payHistory=null;
	
	static TranasactionGooglePayHistory historyEntity=null;
	
	@BeforeAll
	public static void init(){
		
	    System.out.println("BeforeAll init() method called");
	    payHistory=new GooglePayHistoryDTO();
	    
	    historyEntity=new TranasactionGooglePayHistory();
}
	
	@Test
	public void fundHistory() {
		
	//Mockito.when(googlePayRepo.findByToPhoneNumberOrFromPhoneNumber("7598125418", "7598125419", 5).thenReturn(null));
  
		payHistory.setFromPhoneNumber("7598125418");
		payHistory.setToPhoneNumber("7397368541");
		payHistory.setAmount("5000");
		payHistory.setRemarks("Credit");
		payHistory.setTranID(0);
		Mockito.when(googlePayRepo.save(historyEntity)).thenReturn(null);
		List<GooglePayHistoryDTO> fundTransferBalance = history.getGoolePayHistory("7598125418", "7397368541", "1");
		assertEquals(fundTransferBalance,payHistory);

	}
	}

