package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.ItemPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PriceRepository extends JpaRepository<ItemPrice, String>{
	
	@Query(value = "select     it.item_name,     ipm.price,     ipm.uuid from     items it         inner join     item_pricing ipm on it.uuid = ipm.item_id         left join     item_category ic on ic.uuid = ipm.items_category_uuid where     ipm.status = 'A' and  ic.uuid=:categoryId and ipm.shop_uuid=:shopUuid  and it.unit_type ='pc' and  ipm.price!=0 order by it.item_name",nativeQuery = true)
	List<ItemPrice> findByIpmUuid(@Param("categoryId") String categoryId,@Param("shopUuid") String shopUuid);

}
