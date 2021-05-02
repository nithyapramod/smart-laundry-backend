package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.TimeSlots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimeSlotsRepository extends JpaRepository<TimeSlots, String> {

	@Query(value = "SELECT     uuid,shop_uuid,slot,status,   IFNULL(TIME_FORMAT(start_at, '%h:%i %p') ,'Any')start_at,     IFNULL(TIME_FORMAT(end_at, '%h:%i %p') ,'time')end_at  FROM     time_slots  where slot  between :st and :et", nativeQuery = true)
	List<TimeSlots> findBySlot(@Param("st") Integer st, @Param("et") Integer et);

}
