package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethods, String> {

	List<PaymentMethods> findByStatus(String status);

}
