package com.googlepay.service;

import java.util.List;

import com.googlepay.dto.GooglePayHistoryDTO;

public interface GooglePayHistoryService {

	
	public List<GooglePayHistoryDTO> getGoolePayHistory(String toPhoneNumber,String fromPhoneNumber,String pagination);

}
