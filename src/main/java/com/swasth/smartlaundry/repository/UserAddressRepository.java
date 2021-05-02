package com.swasth.smartlaundry.repository;

import java.util.List;
import java.util.Optional;

import com.swasth.smartlaundry.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, String> {
	
	
	List<UserAddress> findByUserUuid(String userUuid);
	
 	Optional<UserAddress> findByUserUuidAndAddressType(String userUuid,String addressType);

 
}
