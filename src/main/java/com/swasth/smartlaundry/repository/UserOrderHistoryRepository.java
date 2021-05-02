package com.swasth.smartlaundry.repository;

import java.util.List;
import java.util.Optional;

import com.swasth.smartlaundry.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserOrderHistoryRepository extends JpaRepository<OrderHistory, String>{

	
	@Query(value = " select   uo.bag_number,uo.ord_id,u.phone_number,     u.address,  u.uuid as shop_uuid,	u.shop_name,     uo.uuid,     uo.status,  uo.assign_on,   uo.order_on,      uo.pickup_on, uo.cancel_on, uo.delivery_on,     uo.slot_time from     user_order uo         inner join     users u on u.uuid = uo.shop_uuid     inner join     users us on us.uuid = uo.user_uuid where     us.uuid=:userUuid",nativeQuery = true)
	List<OrderHistory> findByCustomerName(@Param("userUuid") String userUuid);
	
	
	@Query(value = " select   uo.bag_number,uo.ord_id,u.phone_number,     u.address, u.uuid as shop_uuid,	u.shop_name,     uo.uuid,     uo.status,  uo.assign_on,   uo.order_on,      uo.pickup_on,uo.cancel_on, 	uo.delivery_on,     uo.slot_time from     user_order uo         inner join     users u on u.uuid = uo.shop_uuid     inner join     users us on us.uuid = uo.user_uuid where     uo.uuid=:orderUuid",nativeQuery = true)
	Optional<OrderHistory> findByUuid(@Param("orderUuid") String orderUuid);

}
