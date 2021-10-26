
  package com.googlepay.repostory;
 
 
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.googlepay.entity.UserRegistration;
 
 
 @Repository 
 public interface UserRepostory extends JpaRepository<UserRegistration,Integer>{
  
	 UserRegistration findByPhoneNumber(String Phone);
 
 }
 