package com.swasth.smartlaundry.services;

import java.util.List;

import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.entity.ShopVerification;
import com.swasth.smartlaundry.model.AdminVerification;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.ShopVerificationRepository;
import com.swasth.smartlaundry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ShopVerificationService {

    @Autowired
    private ShopVerificationRepository shopVerificationRepository;

    @Autowired
    private UserRepository userRepository;

    public Response getAdminShopDetails(String adminUuid) throws Exception {

        List<ShopVerification> shopsList = shopVerificationRepository.findByAdminUuid(adminUuid);
        if (shopsList.size() > 0) {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            String resultW = objectMapper.writer().withRootName("shopsList").writeValueAsString(shopsList);
            JsonNode finalResult = objectMapper.readTree(resultW);
            return Response.createSuccess(true, HttpStatus.OK.value(), "Shops details", finalResult);

        } else {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "No Shops are found under him", null);

        }

    }

    public Response updateShopStatus(AdminVerification av) throws Exception {

        /**
         * status 1 means accept status 2 means reject 3 inactive
         */
        Integer status = 0;
        if (av.getStatus() == 2) {
            status = userRepository.updateByStatus("IA", av.getShopUuid());
            if (av.getAdminUuid().startsWith("su")) {
                status = shopVerificationRepository.updateByShopVerification("rejected", av.getShopUuid());
            } else {
                status = shopVerificationRepository.updateByShopVerification("rejected", av.getAdminUuid(),
                        av.getShopUuid());

            }
        } else if (av.getStatus() == 3) {
            status = userRepository.updateByStatus("IA", av.getShopUuid());

        } else {
            status = userRepository.updateByStatus("A", av.getShopUuid());
            if (av.getAdminUuid().startsWith("su")) {

                status = shopVerificationRepository.updateByShopVerification("verified", av.getShopUuid());
            } else {
                status = shopVerificationRepository.updateByShopVerification("verified", av.getAdminUuid(),
                        av.getShopUuid());

            }

        }

        if (status != 0) {

            if (av.getStatus() == 3) {
                return Response.createSuccess(true, HttpStatus.OK.value(), "shop was inactive successfully", null);
            } else if (av.getStatus() == 2) {
                return Response.createSuccess(true, HttpStatus.OK.value(), "shop was rejected successfully", null);
            } else {
                return Response.createSuccess(true, HttpStatus.OK.value(), "shop verification has been done", null);
            }
        } else {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "shop details are not found", null);

        }

    }

}
