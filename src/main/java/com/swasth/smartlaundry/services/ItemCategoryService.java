package com.swasth.smartlaundry.services;

import java.util.List;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.entity.ItemCategory;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemCategoryService {

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    public Response getAllitemCategories() throws Exception {

        List<ItemCategory> itemCategory = itemCategoryRepository.findByStatus("A");

        if (itemCategory.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Details Not Found", itemCategory);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writer().withRootName("itemCategoryDetails").writeValueAsString(itemCategory);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

}
