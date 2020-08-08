package com.pramod.gireesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramod.gireesh.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{
	
	public UserModel findByPhnumber(String phnumber);
	
}
 