package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.model.PriceModel;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Tag(name = "Items Service")
@RequestMapping("item")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;;

	@GetMapping
	public Response fetchAllItems() throws Exception {
		return itemsService.getAllItems();
	}

	@PostMapping
	public Response fetchAllItemsWithPrice(@RequestBody PriceModel priceModel) throws Exception {
		return itemsService.getItemPriceMapping(priceModel);
	}
	
	@PostMapping("kg")
	public Response fetchAllKgItemsWithPrice(@RequestBody PriceModel priceModel) throws Exception {
		return itemsService.getPricingPerKgMapping(priceModel);
	}

}
