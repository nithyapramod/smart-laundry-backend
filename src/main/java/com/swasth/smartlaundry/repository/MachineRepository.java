package com.swasth.smartlaundry.repository;

import com.swasth.smartlaundry.model.MachineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<MachineModel, Integer>{

	public MachineModel findByMacUniqueId(String macUniqueId);
	

	
} 