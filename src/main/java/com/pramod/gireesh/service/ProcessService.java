package com.pramod.gireesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramod.gireesh.model.ProcessModel;
import com.pramod.gireesh.repository.ProcessRepository;

@Service
public class ProcessService {
	
	@Autowired
	ProcessRepository processRepository;

	public List<ProcessModel> getProcessDetails(String macUniqueId) {
		return processRepository.findByMacUniqueId(macUniqueId);
	}

	
}
