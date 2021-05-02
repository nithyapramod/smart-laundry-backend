package com.swasth.smartlaundry.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.swasth.smartlaundry.entity.OrderGrid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderGridRepository extends JpaRepository<OrderGrid, String> {

	@Query("select o from OrderGrid o where o.shopUuid=:shopUuid and Date(o.createdOn)= Date(:createdOn)")
	Optional<OrderGrid> findByShopUuidAndCreatedOn(String shopUuid, Date createdOn);

	List<OrderGrid> findByShopUuid(String shopUuid);
	
	@Query(value = "SELECT  sog.uuid,sog.shop_uuid,sog.created_on,sum(total_orders)total_orders  ,  sum(ongoing_orders)ongoing_orders  , sum(completed_orders)completed_orders  ,  sum(cancel_orders)cancel_orders  ,  sum(total_revenue)total_revenue    from  shop_order_grid sog inner join shop_verification sv on sv.shop_uuid=sog.shop_uuid ",nativeQuery = true)
	OrderGrid findByCreatedOn();
	
	@Query(value = "SELECT  sog.uuid,sog.shop_uuid,sog.created_on,sum(total_orders)total_orders  ,  sum(ongoing_orders)ongoing_orders  , sum(completed_orders)completed_orders  ,  sum(cancel_orders)cancel_orders  ,  sum(total_revenue)total_revenue    from  shop_order_grid sog inner join shop_verification sv on sv.shop_uuid=sog.shop_uuid where sv.admin_uuid=:adminUuid ",nativeQuery = true)
	OrderGrid findByAdminUuid(@Param("adminUuid") String adminUuid);


}
