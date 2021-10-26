package com.googlepay.repostory;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.googlepay.entity.TranasactionGooglePayHistory;

public interface TransactionGoogleyPayRepo extends JpaRepository<TranasactionGooglePayHistory, Integer>{
	
	public List<TranasactionGooglePayHistory> findByToPhoneNumberOrFromPhoneNumber(String toPhoneNumber,String fromPhoneNumber,Pageable pageable);


}
