package com.swasth.smartlaundry.services;

import java.util.List;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.entity.UserType;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    public Response getAllUserTypes() throws Exception {

        List<UserType> userTypes = userTypeRepository.findByUserType();

        if (userTypes.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Details Not Found", userTypes);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writer().withRootName("userTypeDetails").writeValueAsString(userTypes);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

}
