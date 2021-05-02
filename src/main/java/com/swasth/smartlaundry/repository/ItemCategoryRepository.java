package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, String>{
	
	List<ItemCategory> findByStatus(String status);

}
