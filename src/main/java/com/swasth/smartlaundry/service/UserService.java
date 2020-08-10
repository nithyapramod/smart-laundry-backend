package com.swasth.smartlaundry.service;
import com.swasth.smartlaundry.model.UserModel;
import com.swasth.smartlaundry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
    UserRepository userRepository;
	
	public String handleLogin(UserModel user) {
		UserModel dbUser = userRepository.findByPhnumber(user.getPhnumber());
		System.out.println(dbUser);
		if (dbUser == null) {
			return "{\"result\" : \"fail\",	\"message\" : \"user doens't exist\"}";
		}
		if (user.getPassword().equals(dbUser.getPassword())) {
			return "{\"result\" : \"success\",	\"message\" : \"\"}";
		}
		return "{\"result\" : \"fail\",	\"message\" : \"password mismatch\"}";
	}

	public String handleOtp(String phnumber) {
		System.out.println("Number: " + phnumber);
		UserModel dbUser = userRepository.findByPhnumber(phnumber);
		if (dbUser != null) {
			return "{\"otp\": \"123456\", \"userId\": " + dbUser.getUserId() + "}";
		}
		// send otp over sms to phnumber
		return "{\"otp\": \"123456\"}";
	}

	public UserModel handleSignup(UserModel user) {
		UserModel dbUser =  userRepository.save(user);
		System.out.println("Saved UserId: " + dbUser.getUserId());
		return dbUser;
	}

	public UserModel handleForgetPassword(UserModel user) {
		return userRepository.save(user);
	}

}
