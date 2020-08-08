package com.pramod.gireesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pramod.gireesh.model.MachineModel;
import com.pramod.gireesh.repository.MachineRepository;


        @Service
		public class MachineService {
        	
        @Autowired
        MachineRepository machineRepository;

	
		public MachineModel handlemacreg(MachineModel machine) {
			MachineModel dbMachine =  machineRepository.save(machine);
			return dbMachine;
		}


		public String handleMacOwner(String macUniqueId) {
			MachineModel dbMachine = machineRepository.findByMacUniqueId(macUniqueId);
			if (dbMachine != null) {
				return "{\"otp\": \"123456\", \"macId\": " + dbMachine.getMacUniqueId() + "}";
			}
			//System.out.println("Saved MacId: " + dbMachine.getMacId());
			 return null;
		}
		
}
