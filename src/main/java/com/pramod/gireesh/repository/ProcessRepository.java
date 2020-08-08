package com.pramod.gireesh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramod.gireesh.model.ProcessModel;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessModel, Integer> {

	public List<ProcessModel> findByMacUniqueId(String macUniqueId);
	
}
