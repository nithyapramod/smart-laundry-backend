package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.ItemPricePerKg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PricePerKgRepository extends JpaRepository<ItemPricePerKg, String>{
	
	@Query(value = "select     ipkg.uuid, ipkg.price, ipkg.quantity from     items_pricing_per_kg ipkg where     ipkg.status = 'A' and ipkg.category_uuid=:categoryId and ipkg.shop_uuid=:shopUuid  and ipkg.price!=0 order by ipkg.quantity",nativeQuery = true)
	List<ItemPricePerKg> findByIpkgUuid(@Param("categoryId") String categoryId,@Param("shopUuid") String shopUuid);

}
