package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.model.MItemPricingPerKg;
import com.swasth.smartlaundry.model.PriceModel;
import com.swasth.smartlaundry.model.PricingModel;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.services.ItemPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Tag(name = "Price Service")
@RequestMapping("price")
public class PriceController {

	@Autowired
	private ItemPriceService itemPriceService;

	@PostMapping
	public @ResponseBody Response fetchItemPriceDetails(@RequestBody PriceModel priceModel) throws Exception {
		return itemPriceService.getItemPriceDetails(priceModel);
	}

	/*
	 * @PostMapping("mapping") public @ResponseBody Response
	 * createPricing(@RequestBody PricingModel pricingModel) throws Exception {
	 * return itemPriceService.createPricing(pricingModel.getItemPricings()); }
	 */
	
	@PostMapping("/perPc/mapping")
	public @ResponseBody Response createPricing(@RequestBody PricingModel pricingModel) throws Exception {
		return itemPriceService.createPricing(pricingModel.getItemPricing());
	}

	@PostMapping("perKg")
	public Response fetchItemPricePerKg(@RequestBody PriceModel priceModel) throws Exception {
		return itemPriceService.getItemPricePerKg(priceModel);
	}
	
	@PostMapping("/perKg/mapping")
	public @ResponseBody Response createPerKgPricing(@RequestBody MItemPricingPerKg mItemPricingPerKg) throws Exception {
		return itemPriceService.createPricingPerKg(mItemPricingPerKg);
	}

}
