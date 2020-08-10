package com.swasth.smartlaundry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swasth.smartlaundry.model.ProcessModel;
import com.swasth.smartlaundry.repository.ProcessRepository;

@Service
public class ProcessService {
	
	@Autowired
	ProcessRepository processRepository;

	public List<ProcessModel> getProcessDetails(String macUniqueId) {
		return processRepository.findByMacUniqueId(macUniqueId);
	}

	
}
