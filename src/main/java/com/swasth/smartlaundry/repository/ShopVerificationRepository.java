package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.ShopVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopVerificationRepository extends JpaRepository<ShopVerification, String> {

	List<ShopVerification> findByAdminUuid(String adminUuid);

	@Modifying
	@Query("update ShopVerification set shStatus=:status where adminUuid=:adminUuid and shopUuid=:shopUuid")
	Integer updateByShopVerification(@Param("status") String status, @Param("adminUuid") String adminUuid,
			@Param("shopUuid") String shopUuid);
	

	@Modifying
	@Query("update ShopVerification set shStatus=:status where  shopUuid=:shopUuid")
	Integer updateByShopVerification(@Param("status") String status, @Param("shopUuid") String shopUuid);

}
