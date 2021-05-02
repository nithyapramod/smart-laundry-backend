package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.WorkHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkHistoryRepository extends JpaRepository<WorkHistory, String> {
	
	@Query(value = "SELECT 	sog.uuid,     sv.shop_uuid,     sv.shop_name,     sv.status, 	sv.remarks,     sog.total_orders,     sog.ongoing_orders,     sog.completed_orders,     sog.cancel_orders,     sog.total_revenue,     sog.created_on FROM     shop_verification sv         INNER JOIN     shop_order_grid sog ON sv.shop_uuid = sog.shop_uuid WHERE     sv.admin_uuid = :adminUuid",nativeQuery = true)
	List<WorkHistory> findByAdminUuid(@Param("adminUuid") String adminUuid);
	
	@Query(value = "SELECT 	sog.uuid,     sv.shop_uuid,     sv.shop_name,     sv.status, 	sv.remarks,     sog.total_orders,     sog.ongoing_orders,     sog.completed_orders,     sog.cancel_orders,     sog.total_revenue,     sog.created_on FROM     shop_verification sv         INNER JOIN     shop_order_grid sog ON sv.shop_uuid = sog.shop_uuid WHERE      sv.shop_uuid= :shopUuid",nativeQuery = true)
	List<WorkHistory> findByShopUuid(@Param("shopUuid") String shopUuid);

}
