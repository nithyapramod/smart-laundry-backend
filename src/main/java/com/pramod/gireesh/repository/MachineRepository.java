package com.pramod.gireesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramod.gireesh.model.MachineModel;

@Repository
public interface MachineRepository extends JpaRepository<MachineModel, Integer>{

	public MachineModel findByMacUniqueId(String macUniqueId);
	

	
} 