package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.services.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Tag(name = "Item Categories Service")
@RequestMapping("category")
public class ItemCategoryController {

	@Autowired
	private ItemCategoryService itemCategoryService;;

	@GetMapping
	public Response fetchAllitemCategories() throws Exception {
		return itemCategoryService.getAllitemCategories();
	}
	
	/*
	 * @PostMapping public Response insertItemCategories(@RequestBody ItemCategory
	 * itemCategory) throws Exception { return
	 * itemCategoryService.createCategories(itemCategory); }
	 */

}
