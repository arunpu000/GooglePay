package com.googlepay.service;

import com.googlepay.dto.FundTrasfer;
import com.googlepay.exception.UserDefinedException;

public interface FundTransferService {

	 public String fundTransferGooglePay(FundTrasfer fundTransfer)throws UserDefinedException;

}
