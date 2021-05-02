package com.swasth.smartlaundry.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.constraints.CommonConstants;
import com.swasth.smartlaundry.entity.GetItemPricing;
import com.swasth.smartlaundry.entity.GetItemPricingPerKg;
import com.swasth.smartlaundry.entity.Item;
import com.swasth.smartlaundry.model.ItemStatus;
import com.swasth.smartlaundry.model.PriceModel;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.GetPriceRepository;
import com.swasth.smartlaundry.repository.GetPricingPerKgRepository;
import com.swasth.smartlaundry.repository.ItemRepository;
import com.swasth.smartlaundry.util.UuidGenarator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemsService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private GetPriceRepository getPriceRepository;

    @Autowired
    private GetPricingPerKgRepository getPricingPerKgRepository;


    public Response addItem(Item item) throws Exception {

        try {

            if ((item.getItemName() != null) && (!item.getItemName().isEmpty())) {

                Optional<Item> opItem = itemRepository.findByShopUuidAndItemName("G", item.getItemName());
                if (opItem.isPresent()) {
                    return Response.createError(false, HttpStatus.NOT_ACCEPTABLE.value(), "item was already exists",
                            null);

                }

                item.setUuid(UuidGenarator.gen(CommonConstants.ITEMS_PREFIX));
                itemRepository.save(item);

            }

            return Response.createSuccess(true, HttpStatus.CREATED.value(), "Item was added successfully", null);

        } catch (Exception e) {
            return Response.createError(false, HttpStatus.NOT_ACCEPTABLE.value(), "Unable to create an item", null);
        }

    }

    public Response getAllItems() throws Exception {

        List<Item> itemsList = itemRepository.findAll();

        if (itemsList.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Details Not Found", itemsList);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            //mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            String result = mapper.writer().withRootName("itemDetails").writeValueAsString(itemsList);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

    public Response getItemPriceMapping(PriceModel priceModel) throws JsonProcessingException {
        List<GetItemPricing> itemPrice = getPriceRepository.findByItemName(priceModel.getCategoryId(),
                priceModel.getShopUuid());

        if (itemPrice.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Details Not Found", itemPrice);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writer().withRootName("itemPriceMapping").writeValueAsString(itemPrice);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

    public Response getPricingPerKgMapping(PriceModel priceModel) throws JsonProcessingException {
        List<GetItemPricingPerKg> itemPrice = getPricingPerKgRepository.findByItemName(priceModel.getCategoryId(),
                priceModel.getShopUuid());

        if (itemPrice.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Details Not Found", itemPrice);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writer().withRootName("itemPriceKgMapping").writeValueAsString(itemPrice);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

    public Response updateItem(ItemStatus itemStatus) {

        /**
         * status 1 means active status 2 means inactive
         */
        Integer status = 0;
        if (itemStatus.getItemStatus() == 2) {
            status = itemRepository.updateByStatus("IA", itemStatus.getItemUuid());

            return Response.createSuccess(true, HttpStatus.OK.value(), "user status changed active to inactive", null);

        } else {
            status = itemRepository.updateByStatus("A", itemStatus.getItemUuid());

            return Response.createError(true, HttpStatus.OK.value(), "user status changed inactive to active", null);

        }

    }

}
