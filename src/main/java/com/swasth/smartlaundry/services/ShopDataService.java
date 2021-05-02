package com.swasth.smartlaundry.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.entity.ItemCategory;
import com.swasth.smartlaundry.entity.TimeSlots;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.model.ShopData;
import com.swasth.smartlaundry.model.ShopDataInput;
import com.swasth.smartlaundry.repository.ItemCategoryRepository;
import com.swasth.smartlaundry.repository.TimeSlotsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ShopDataService {

    @Autowired
    private TimeSlotsRepository timeSlotsRepository;

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    public Response getShopData(String shopUuid) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        try {

            List<ItemCategory> itemCategory = itemCategoryRepository.findByStatus("A");

            ShopData shopData = BeanUtils.instantiateClass(ShopData.class);
            shopData.setItemCategory(itemCategory);

            String result = mapper.writer().withRootName("shopData").writeValueAsString(shopData);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);
        } catch (Exception e) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Details Not Found", null);
        }

    }

    public Response getTimeSlotsData(ShopDataInput shopDataInput) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String userTime = new SimpleDateFormat("dd-MM-yyyy").format(shopDataInput.getSlotDate());

            Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(userTime);
            String serverTime = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(serverTime);
            List<TimeSlots> timeSlots = new ArrayList<TimeSlots>();

            System.out.println(userTime);
            System.out.println(serverTime);

            if (userTime.equals(serverTime)) {

                Map<Integer, Integer> s = new HashMap<Integer, Integer>();
                s.put(5, 1);
                s.put(6, 1);
                s.put(7, 1);
                s.put(8, 1);
                s.put(9, 1);
                s.put(10, 2);
                s.put(11, 3);
                s.put(12, 4);
                s.put(13, 5);
                s.put(14, 5);
                s.put(15, 5);
                s.put(16, 6);
                s.put(17, 7);

                SimpleDateFormat df = new SimpleDateFormat("yyyy-Mm-dd'T'HH:mm:ss");

                Date date = df.parse(df.format(shopDataInput.getSlotDate()));
                System.out.println(date);
                SimpleDateFormat sdf = new SimpleDateFormat("HH");
                String shortTimeStr = sdf.format(date);
                System.out.println(shortTimeStr);
                Integer st = s.get(Integer.valueOf(shortTimeStr));
                if (st != null) {
                    timeSlots = timeSlotsRepository.findBySlot(st, 7);

                } else {
                    String result = mapper.writer().withRootName("timeSlots").writeValueAsString(Collections.EMPTY_LIST);
                    JsonNode finalResult = mapper.readTree(result);
                    return Response.createError(false, HttpStatus.OK.value(), "Shop timings are 9 AM - 6 PM", finalResult);

                }

            } else if (date1.before(date2)) {
                String result = mapper.writer().withRootName("timeSlots").writeValueAsString(Collections.EMPTY_LIST);
                JsonNode finalResult = mapper.readTree(result);
                return Response.createError(false, HttpStatus.OK.value(), "Slot details not found", finalResult);

            } else {
                timeSlots = timeSlotsRepository.findBySlot(1, 7);

            }
            String result = mapper.writer().withRootName("timeSlots").writeValueAsString(timeSlots);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        } catch (Exception e) {

            System.out.println(e);

            String result = mapper.writer().withRootName("timeSlots").writeValueAsString(Collections.EMPTY_LIST);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createError(false, HttpStatus.OK.value(), "Details Not Found", finalResult);
        }

    }

}
