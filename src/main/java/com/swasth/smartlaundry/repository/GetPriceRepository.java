package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.GetItemPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GetPriceRepository extends JpaRepository<GetItemPricing, String> {

	@Query(value = "SELECT     it.item_name, coalesce( ipm.price,0) price, it.uuid item_id,ic.uuid item_category_uuid,coalesce(ipm.shop_uuid,:shopUuid) as shop_uuid FROM     items it         LEFT JOIN     item_pricing ipm ON it.uuid = ipm.item_id and ipm.shop_uuid=:shopUuid  and ipm.items_category_uuid=:categoryId     LEFT JOIN     item_category ic ON ic.uuid  = :categoryId where it.unit_type ='pc' ", nativeQuery = true)
	List<GetItemPricing> findByItemName(@Param("categoryId") String categoryId, @Param("shopUuid") String shopUuid);

}
