package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.CancelReason;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelReasonRepository extends JpaRepository<CancelReason, String> {

	List<CancelReason> findByReasonType(int reasonType);
}
