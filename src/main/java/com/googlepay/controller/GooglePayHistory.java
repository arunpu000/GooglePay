package com.googlepay.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.googlepay.dto.GooglePayHistoryDTO;
import com.googlepay.service.GooglePayHistoryService;

@RestController
public class GooglePayHistory {

	@Autowired
	GooglePayHistoryService history;
	
	@GetMapping("/history")
	public List<GooglePayHistoryDTO>  trasactionHistory(@Valid @RequestParam String phoneNumber) {
		List<GooglePayHistoryDTO> transactionHistory = history.getGoolePayHistory(phoneNumber, phoneNumber, phoneNumber);
		return transactionHistory;
	}
}
