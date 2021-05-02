package com.swasth.smartlaundry.repository;

import java.util.Optional;

import com.swasth.smartlaundry.entity.ItemPricingPerKg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingPerKgRepository extends JpaRepository<ItemPricingPerKg, String> {
	
	
	Optional<ItemPricingPerKg> findByItemsCategoryUuidAndShopUuidAndStatus(String catId,String shopUuid,String status);

}
