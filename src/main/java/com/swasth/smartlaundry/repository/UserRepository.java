package com.swasth.smartlaundry.repository;

import com.swasth.smartlaundry.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByPhoneNumberAndPasswordAndIsActiveTrue(String phoneNumber, String password);

    Optional<User> findByPhoneNumberAndIsActiveTrue(String phoneNumber);

}
 