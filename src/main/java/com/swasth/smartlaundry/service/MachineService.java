package com.swasth.smartlaundry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swasth.smartlaundry.model.MachineModel;
import com.swasth.smartlaundry.repository.MachineRepository;


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
