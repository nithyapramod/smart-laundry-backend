package com.swasth.smartlaundry.repository;

import java.util.List;
import java.util.Optional;

import com.swasth.smartlaundry.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, String> {

	List<Item> findByStatus(String status);

	Optional<Item> findByShopUuidAndItemName(String shopUuid, String itemName);

	@Modifying
	@Query("update Item set status=:status where uuid=:itemUuid")
	Integer updateByStatus(@Param("status") String status, @Param("itemUuid") String itemUuid);
	
}
