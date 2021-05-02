package com.swasth.smartlaundry.repository;

import java.util.Date;

import com.swasth.smartlaundry.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserOrderRepository extends JpaRepository<UserOrder, String> {

	@Modifying
	@Query("update UserOrder set status=:status where uuid=:orderUuid ")
	Integer updateOrderStatus(@Param("status") String status, @Param("orderUuid") String orderUuid);


	@Modifying
	@Query("update UserOrder set status=:status,pickupOn=:pickupOn,totalWeight=:totalWeight,bagNumber=:bagNumber where uuid=:orderUuid ")
	Integer updateByPickupOn(@Param("bagNumber") String bagNumber,@Param("totalWeight")  Double totalWeight,@Param("status") String status,@Param("pickupOn") Date pickupOn, @Param("orderUuid") String orderUuid);

	@Modifying
	@Query("update UserOrder set status=:status,cancelOn=:cancelOn,remarks=:remarks where uuid=:orderUuid ")
	Integer updateByCancelOn(@Param("status") String status,@Param("cancelOn") Date cancelOn, @Param("orderUuid") String orderUuid, @Param("remarks") String remarks);

	@Modifying
	@Query("update UserOrder set status=:status, deliveryOn=:deliveryOn where uuid=:orderUuid ")
	Integer updateByDeliveryOn(@Param("status") String status,@Param("deliveryOn") Date deliveryOn, @Param("orderUuid") String orderUuid);

	@Modifying
	@Query("update UserOrder set refNumber=:refNumber where uuid=:orderUuid")
	Integer updateByRefNumber(String refNumber, String orderUuid);

 
}
