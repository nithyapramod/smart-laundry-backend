package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.entity.Item;
import com.swasth.smartlaundry.model.AdminRegistration;
import com.swasth.smartlaundry.model.AdminStatus;
import com.swasth.smartlaundry.model.AdminVerification;
import com.swasth.smartlaundry.model.Dashboard;
import com.swasth.smartlaundry.model.ItemStatus;
import com.swasth.smartlaundry.model.Login;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.services.ItemsService;
import com.swasth.smartlaundry.services.ShopVerificationService;
import com.swasth.smartlaundry.services.UserService;
import com.swasth.smartlaundry.services.WorkHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Tag(name = "Admim Services")
@RequestMapping("ad")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private ShopVerificationService shopVerificationService;
	
	@Autowired
	private WorkHistoryService workHistoryService;
	
	@Autowired
	private ItemsService itemsService;

	@PostMapping("login")
	public Response superAdminLogin(@RequestBody Login login) throws Exception {
		return userService.getUserDetails(login);
	}

	@PostMapping("create")
	public Response createAdminUser(@RequestBody AdminRegistration adminRegistration) throws Exception {
		return userService.createAdmin(adminRegistration);
	}
	
	@PostMapping("dashboard")
	public Response superdashboard(@RequestBody Dashboard dashboard) throws Exception {
		return userService.getSuperDashboard(dashboard);
	}
	
	@PostMapping("status/change")
	public Response statusChange(@RequestBody AdminStatus adminStatus) throws Exception {
		return userService.updateAdminStatus(adminStatus);
	}


	@GetMapping
	public Response getAllAdmin() throws Exception {
		return userService.getAllAdmins();
	}
	
	
	
	
	/*
	 * @GetMapping("{adminUuid}/verification/details") public Response
	 * workHistory(@PathVariable("adminUuid") String adminUuid) throws Exception {
	 * return workHistoryService.workHistory(adminUuid); }
	 */
	
	@GetMapping("{shopUuid}/verification/details")
	public Response shopDetails(@PathVariable("shopUuid") String shopUuid) throws Exception {
		return workHistoryService.shopDetails(shopUuid);
	}
	
	@GetMapping("{adminUuid}/shops/under")
	public Response getAdminShopList(@PathVariable("adminUuid") String adminUuid) throws Exception {
		return shopVerificationService.getAdminShopDetails(adminUuid);
	}

	@PostMapping("shop/verification")
	public Response updateShopStatus(@RequestBody AdminVerification av) throws Exception {
		return shopVerificationService.updateShopStatus(av);
	}
	
	@PostMapping("add/item")
	public Response updateItem(@RequestBody Item item) throws Exception {
		return itemsService.addItem(item);
	}
	
	@PostMapping("change/item/status")
	public Response itemStatus(@RequestBody ItemStatus itemStatus) throws Exception {
		return itemsService.updateItem(itemStatus);
	}
	
}
