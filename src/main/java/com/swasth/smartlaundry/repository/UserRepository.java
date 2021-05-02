package com.swasth.smartlaundry.repository;

import java.util.List;
import java.util.Optional;

import com.swasth.smartlaundry.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

	@Modifying
	@Query("update User set fcmKey=:fcmKey where uuid=:userUuid")
	Integer updateByFcmKey(@Param("fcmKey") String fcmKey, @Param("userUuid") String userUuid);
	
	
	@Modifying
	@Query("update User set status=:status where uuid=:userUuid")
	Integer updateByStatus(@Param("status") String status, @Param("userUuid") String userUuid);
	
	@Modifying
	@Query("update User set password=:password where phoneNumber=:phoneNumber and  userType=:userType" )
	Integer updateByPassword(@Param("password") String password, @Param("phoneNumber") String phoneNumber,@Param("userType") int userType);

	@Query("select u from User u where (u.phoneNumber=:phoneNumber or u.email=:email) and u.userType=:userType and u.status='A'")
	Optional<User> findByPhoneNumber(@Param("phoneNumber") String phoneNumber, @Param("email") String email,
			@Param("userType") int userType);
	
 	Optional<User> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

	@Query("select u from User u where u.phoneNumber=:phoneNumber and (u.userType=1 or u.userType=2) and u.status='A'")
	List<User> findByPhoneNumberAndUserType(@Param("phoneNumber") String phoneNumber);

	List<User> findByParentUuidAndUserType(String parentUuid,int userType);
	
	List<User> findByParentUuid(String parentUuid);

	@Query("select u from User u where (u.userName=:userName or u.phoneNumber=:userName) and u.password=:password and u.status='A'")
	Optional<User> findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

	@Modifying
	@Query("update User u set u.password = :password where u.phoneNumber=:userName and u.userType=:userType and u.status='A'")
	Integer restUserPassword(@Param("userName") String userName, @Param("password") String password,
			@Param("userType") int userType);

	Optional<User> findByPhoneNumberAndUserType(String phoneNumber, int userType);

	@Query("select u from User u where u.phoneNumber=:phoneNumber and u.password=:password and u.userType=:userType and u.status='A'")
	Optional<User> findByPhoneNumberAndPassword(@Param("phoneNumber") String phoneNumber,
			@Param("password") String password, @Param("userType") int userType);

	@Query("select u from User u where u.phoneNumber=:phoneNumber and u.password=:password and u.status='A'")
	Optional<User> findByPhoneNumberAndPassword(@Param("phoneNumber") String phoneNumber,
			@Param("password") String password);

	List<User> findByUserType(int userType);

	List<User> findByAdminUuid(String adminUuid);

}
