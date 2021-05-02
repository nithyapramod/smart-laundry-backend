package com.swasth.smartlaundry.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.entity.NearByShops;
import com.swasth.smartlaundry.model.NearBy;
import com.swasth.smartlaundry.model.NearByShopsDetails;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.NearByShopsRepository;
import com.swasth.smartlaundry.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NearByShopsService {

    @Autowired
    private NearByShopsRepository nearByShopsRepository;

    @Value("${distanceToTakeOrder}")
    private Double distanceToTakeOrder;


    @Autowired
    private UserRepository userRepository;

    public Response getNearByShops(NearBy nearBy) throws Exception {

        /**
         * 1 means near by 5 shops
         *
         * 2 means near by all shops
         */
        Double distance = 00.0;

        userRepository.updateByFcmKey(nearBy.getFcmKey(), nearBy.getUserUuid());

        List<NearByShops> nearByShops = new ArrayList<NearByShops>();
        if (nearBy.getType() == 1) {
            nearByShops = nearByShopsRepository.findByShopName(nearBy.getLat(), nearBy.getLng(), 3);

            if (nearByShops.size() > 0) {
                distance = nearByShops.get(0).getDistanceInKm();
            }

        } else {
            nearByShops = nearByShopsRepository.nearByAllShops(nearBy.getLat(), nearBy.getLng(), 3);
            if (nearByShops.size() > 0) {
                distance = nearByShops.get(0).getDistanceInKm();
            }
        }


        List<String> bannerImages = new ArrayList<String>();
        bannerImages.add("delivery.png");
        bannerImages.add("cleaning.png");
        bannerImages.add("pick-up.png");
        bannerImages.add("bg_5.png");

        NearByShopsDetails nearByDetails = BeanUtils.instantiateClass(NearByShopsDetails.class);


        nearByDetails.setNearByShops(nearByShops);

        nearByDetails.setBannerImages(bannerImages);

        if (nearByShops.isEmpty()) {
            return Response.createError(false, HttpStatus.OK.value(), "Shop Details not fount", nearByShops);
        } else {

            ObjectMapper mapper = new ObjectMapper();
            if (distance > distanceToTakeOrder) {
                List<NearByShops> nearByShopss = new ArrayList<NearByShops>();
                nearByDetails.setNearByShops(nearByShopss);

                String result = mapper.writer().withRootName("nearByShopsDetails").writeValueAsString(nearByDetails);
                JsonNode finalResult = mapper.readTree(result);
                return Response.createSuccess(true, HttpStatus.OK.value(), "services are not opened on this area", finalResult);

            } else {
                String result = mapper.writer().withRootName("nearByShopsDetails").writeValueAsString(nearByDetails);
                JsonNode finalResult = mapper.readTree(result);
                return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);
            }


        }
    }

}
