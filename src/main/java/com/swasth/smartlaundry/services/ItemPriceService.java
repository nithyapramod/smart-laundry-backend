package com.swasth.smartlaundry.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.constraints.CommonConstants;
import com.swasth.smartlaundry.entity.ItemPrice;
import com.swasth.smartlaundry.entity.ItemPricePerKg;
import com.swasth.smartlaundry.entity.ItemPricing;
import com.swasth.smartlaundry.entity.ItemPricingPerKg;
import com.swasth.smartlaundry.model.MItemPricingPerKg;
import com.swasth.smartlaundry.model.PriceModel;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.ItemPricingRepository;
import com.swasth.smartlaundry.repository.PricePerKgRepository;
import com.swasth.smartlaundry.repository.PriceRepository;
import com.swasth.smartlaundry.repository.PricingPerKgRepository;
import com.swasth.smartlaundry.util.UuidGenarator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemPriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PricePerKgRepository pricePerKgRepository;

    @Autowired
    private ItemPricingRepository itemPricingRepository;

    @Autowired
    private PricingPerKgRepository pricingPerKgRepository;

    public Response getItemPriceDetails(PriceModel priceModel) throws Exception {

        List<ItemPrice> itemPrice = priceRepository.findByIpmUuid(priceModel.getCategoryId(), priceModel.getShopUuid());
        ObjectMapper mapper = new ObjectMapper();

        if (itemPrice.isEmpty()) {
            String result = mapper.writer().withRootName("itemPriceDetails").writeValueAsString(itemPrice);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createError(false, HttpStatus.OK.value(), "Pricing Details Not Found", finalResult);
        } else {
            String result = mapper.writer().withRootName("itemPriceDetails").writeValueAsString(itemPrice);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

    public Response createPricing(ItemPricing itemPricing) {

        try {
            Optional<ItemPricing> itemPricings = itemPricingRepository.findByItemIdAndShopUuidAndItemsCategoryUuidAndStatus(
                    itemPricing.getItemId(), itemPricing.getShopUuid(), itemPricing.getItemsCategoryUuid(), "A");

            if (itemPricings.isPresent()) {

                itemPricings.get().setStatus("IA");

                itemPricingRepository.save(itemPricings.get());

                itemPricing.setIpmUuid(UuidGenarator.gen(CommonConstants.PRICING_MAPPING_PREFIX));
                itemPricingRepository.save(itemPricing);

            } else {
                itemPricing.setIpmUuid(UuidGenarator.gen(CommonConstants.PRICING_MAPPING_PREFIX));
                itemPricingRepository.save(itemPricing);

            }

            return Response.createSuccess(true, HttpStatus.CREATED.value(), "pricing details updated successfully",
                    null);

        } catch (Exception e) {
            return Response.createError(false, HttpStatus.NOT_MODIFIED.value(), "please map pricing", null);
        }

    }

    public Response createPricingPerKg(MItemPricingPerKg mItemPricingPerKg) {

        try {

            ItemPricingPerKg itemPricing = BeanUtils.instantiateClass(ItemPricingPerKg.class);
            BeanUtils.copyProperties(mItemPricingPerKg, itemPricing);

            Optional<ItemPricingPerKg> itemPricingPerKgs = pricingPerKgRepository
                    .findByItemsCategoryUuidAndShopUuidAndStatus(itemPricing.getItemsCategoryUuid(), itemPricing.getShopUuid(), "A");

            if (itemPricingPerKgs.isPresent()) {

                itemPricingPerKgs.get().setStatus("IA");

                pricingPerKgRepository.save(itemPricingPerKgs.get());

                itemPricing.setIpkgUuid(UuidGenarator.gen(CommonConstants.PRICING_KG_MAPPING_PREFIX));
                pricingPerKgRepository.save(itemPricing);

            } else {
                itemPricing.setIpkgUuid(UuidGenarator.gen(CommonConstants.PRICING_KG_MAPPING_PREFIX));
                pricingPerKgRepository.save(itemPricing);

            }

            return Response.createSuccess(true, HttpStatus.CREATED.value(), "pricing details updated successfully",
                    null);

        } catch (Exception e) {
            return Response.createError(false, HttpStatus.NOT_MODIFIED.value(), "please map pricing", null);
        }

    }

    /*
     * public Response createPricing(List<ItemPricing> itemPricings) {
     *
     * try { for (ItemPricing itemPricing : itemPricings) {
     * itemPricing.setIpmUuid(UuidGenarator.gen(CommonConstants.
     * PRICING_MAPPING_PREFIX)); }
     *
     * itemPricingRepository.saveAll(itemPricings);
     *
     * return Response.createSuccess(true, HttpStatus.CREATED.value(),
     * "pricing details updated successfully", null);
     *
     * } catch (Exception e) { return Response.createError(false,
     * HttpStatus.NOT_MODIFIED.value(), "please map pricing", null); }
     *
     * }
     */

    public Response getItemPricePerKg(PriceModel priceModel) throws JsonProcessingException {
        List<ItemPricePerKg> itemPrice = pricePerKgRepository.findByIpkgUuid(priceModel.getCategoryId(),
                priceModel.getShopUuid());
        ObjectMapper mapper = new ObjectMapper();

        if (itemPrice.isEmpty()) {
            String result = mapper.writer().withRootName("itemPricePerKgDetails").writeValueAsString(itemPrice);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createError(false, HttpStatus.OK.value(), "Pricing Details Not Found", finalResult);
        } else {
            String result = mapper.writer().withRootName("itemPricePerKgDetails").writeValueAsString(itemPrice);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

}
