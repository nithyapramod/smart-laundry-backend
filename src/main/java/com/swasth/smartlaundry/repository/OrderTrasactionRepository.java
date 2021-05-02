package com.swasth.smartlaundry.repository;

import java.util.Optional;

import com.swasth.smartlaundry.entity.OrderTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderTrasactionRepository extends JpaRepository<OrderTransaction, String> {

	@Query("select o from OrderTransaction o where o.orderUuid=:orderUuid")
	Optional<OrderTransaction> findByOrderUuid(@Param("orderUuid") String orderUuid);

}
