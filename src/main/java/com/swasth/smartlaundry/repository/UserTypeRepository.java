package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserTypeRepository extends JpaRepository<UserType, String>{

	@Query("select u from UserType u where u.userType not in(1,2,3)")
	List<UserType> findByUserType();
}
