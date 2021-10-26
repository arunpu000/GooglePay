package com.googlepay.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.googlepay.dto.GooglePayHistoryDTO;
import com.googlepay.entity.TranasactionGooglePayHistory;
import com.googlepay.repostory.TransactionGoogleyPayRepo;
import com.googlepay.service.GooglePayHistoryService;

@Service
public class GooglePayHistoryServiceImpl implements GooglePayHistoryService{

	@Autowired
	TransactionGoogleyPayRepo googlePayRepo;
	
	@Override
	public List<GooglePayHistoryDTO> getGoolePayHistory(String toPhoneNumber,String fromPhoneNumber,String pagination) {
      
		List<GooglePayHistoryDTO> payHistory=new ArrayList<>();
		
		Pageable paggable=PageRequest.of(0, 5);
		List<TranasactionGooglePayHistory> list = googlePayRepo.findByToPhoneNumberOrFromPhoneNumber(toPhoneNumber, fromPhoneNumber, paggable);
		
		for(TranasactionGooglePayHistory history:list) {
			GooglePayHistoryDTO pay=new GooglePayHistoryDTO();
			
		BeanUtils.copyProperties(history, pay);
		pay.getAmount();
		pay.getTranID();
		pay.getFromPhoneNumber();
		pay.getToPhoneNumber();
		pay.getRemarks();
		
		payHistory.add(pay);
		}
		
		return payHistory;
	}
	

}
