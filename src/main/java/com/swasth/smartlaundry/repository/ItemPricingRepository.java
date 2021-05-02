package com.swasth.smartlaundry.repository;

import java.util.Optional;

import com.swasth.smartlaundry.entity.ItemPricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPricingRepository extends JpaRepository<ItemPricing, String> {

	Optional<ItemPricing> findByItemIdAndShopUuidAndItemsCategoryUuidAndStatus(String itemId, String shopUuid,
			String itemsCategoryUuid,String status);

}
