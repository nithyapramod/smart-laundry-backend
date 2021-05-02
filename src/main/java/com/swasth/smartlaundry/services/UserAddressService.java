package com.swasth.smartlaundry.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.swasth.smartlaundry.constraints.CommonConstants;
import com.swasth.smartlaundry.entity.UserAddress;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.UserAddressRepository;
import com.swasth.smartlaundry.util.UuidGenarator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    public Response createUserAddress(UserAddress userAddress) throws Exception {

        try {

            if (!userAddress.getAddressType().equalsIgnoreCase("other")) {

                Optional<UserAddress> address = userAddressRepository
                        .findByUserUuidAndAddressType(userAddress.getUserUuid(), userAddress.getAddressType());

                if (address.isPresent()) {

                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.setSerializationInclusion(Include.NON_NULL);
                    String oldData = objectMapper.writer().writeValueAsString(address.get());
                    UserAddress defaults = objectMapper.readValue(oldData, UserAddress.class);
                    ObjectReader updater = objectMapper.readerForUpdating(defaults);
                    String newData = objectMapper.writer().writeValueAsString(userAddress);
                    UserAddress merged = updater.readValue(newData);
                    merged.setCreatedOn(new Date());
                    userAddress = userAddressRepository.save(merged);

                } else {
                    userAddress.setUuid(UuidGenarator.gen(CommonConstants.ADDRESS_PREFIX));
                    userAddress.setCreatedOn(new Date());
                    userAddress = userAddressRepository.save(userAddress);
                }
            } else {
                userAddress.setUuid(UuidGenarator.gen(CommonConstants.ADDRESS_PREFIX));
                userAddress.setCreatedOn(new Date());
                userAddress = userAddressRepository.save(userAddress);
            }

            return Response.createSuccess(true, HttpStatus.CREATED.value(), "user address was successfully created",
                    userAddress);

        } catch (Exception e) {
            System.out.println(e);
            return Response.createError(false, HttpStatus.NOT_MODIFIED.value(), "User address not created", null);
        }

    }

    public Response getAllUserAddress(String userUuid) throws Exception {

        List<UserAddress> userAddress = userAddressRepository.findByUserUuid(userUuid);

        if (userAddress.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Address Details Not Found", userAddress);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writer().withRootName("userAddressDetails").writeValueAsString(userAddress);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

}
