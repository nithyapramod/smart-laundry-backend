package com.swasth.smartlaundry.repository;

import java.util.Optional;

import com.swasth.smartlaundry.entity.OtpStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OtpRepository extends JpaRepository<OtpStore, String>{
	
	OtpStore findByPhoneNumberAndStatus(String phoneNumber,Integer status);
	
	
	Optional<OtpStore> findByPhoneNumberAndOtp(String phoneNumber,String otp);
	
	@Modifying
	@Query("update OtpStore set status=2 where phoneNumber=:phoneNumber")
	Integer updateByPhoneNumber(String phoneNumber);
	
}
