package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.model.ProcessModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessModel, Integer> {

	public List<ProcessModel> findByMacUniqueId(String macUniqueId);
	
}
