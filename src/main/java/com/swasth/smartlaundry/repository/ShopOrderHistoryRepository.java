package com.swasth.smartlaundry.repository;

import java.util.List;
import java.util.Optional;

import com.swasth.smartlaundry.entity.ShopOrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopOrderHistoryRepository extends JpaRepository<ShopOrderHistory, String>{

	@Query(value = "select  uo.bag_number,     u.first_name, 	u.phone_number,     ua.address,     ua.lat ,     ua.lng,     ua.address_type,     uo.uuid,     uo.status,    uo.assign_on,  uo.order_on, uo.cancel_on,  uo.delivery_on,    uo.pickup_on,    uo.slot_time,uo.ord_id from     user_order uo         inner join     user_address ua on ua.uuid = uo.user_address_uuid         inner join     users u on u.uuid = uo.user_uuid where     uo.shop_uuid =:shopUuid",nativeQuery = true)
	List<ShopOrderHistory> findByShopName(@Param("shopUuid") String shopUuid);
	
	
	@Query(value = "select  uo.bag_number,      u.first_name, 	u.phone_number,     ua.address,     ua.lat ,     ua.lng,     ua.address_type,     uo.uuid,     uo.status,   uo.assign_on,   uo.order_on, uo.cancel_on,   uo.delivery_on,    uo.pickup_on,    uo.slot_time,uo.ord_id from     user_order uo         inner join     user_address ua on ua.uuid = uo.user_address_uuid         inner join     users u on u.uuid = uo.user_uuid where     uo.shop_uuid =:shopUuid and uo.status='placed' order by uo.created_on desc limit 1",nativeQuery = true)
	Optional<ShopOrderHistory> findLatestOrder(@Param("shopUuid") String shopUuid);
	
	
	@Query(value = "select   uo.bag_number,  u.first_name, 	u.phone_number,     ua.address,     ua.lat ,     ua.lng,     ua.address_type,     uo.uuid,     uo.status,   uo.assign_on,   uo.order_on, uo.cancel_on,   uo.delivery_on,    uo.pickup_on,    uo.slot_time,uo.ord_id from     user_order uo         inner join     user_address ua on ua.uuid = uo.user_address_uuid         inner join     users u on u.uuid = uo.user_uuid where     uo.uuid =:orderUuid",nativeQuery = true)
	Optional<ShopOrderHistory> findByOrderUuid(@Param("orderUuid") String orderUuid);


}