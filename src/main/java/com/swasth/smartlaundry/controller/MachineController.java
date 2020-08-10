package com.swasth.smartlaundry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.swasth.smartlaundry.model.MachineModel;
import com.swasth.smartlaundry.model.ProcessModel;
import com.swasth.smartlaundry.service.MachineService;
import com.swasth.smartlaundry.service.ProcessService;

@RestController
@RequestMapping("/machine")
public class MachineController {

	@Autowired
	private MachineService machineService;
	
	@Autowired
	private ProcessService processService;
	
	@RequestMapping(method = RequestMethod.POST, value="/ownamac", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateOwnerOtp(@RequestBody String macUniqueId) {
		return machineService.handleMacOwner(macUniqueId);	
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/reg", produces = MediaType.APPLICATION_JSON_VALUE)
	public MachineModel macreg(@RequestBody MachineModel machine) {
	return machineService.handlemacreg(machine);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/processDetails/{macUniqueId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProcessModel> processDetails(@PathVariable("macUniqueId") String macUniqueId) {
		return processService.getProcessDetails(macUniqueId);
	}
}
