package com.swasth.smartlaundry.services;

import java.util.List;

import javax.transaction.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.entity.WorkHistory;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.WorkHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WorkHistoryService {

    @Autowired
    private WorkHistoryRepository workHistoryRepository;

    public Response workHistory(String adminUuid) throws JsonProcessingException {

        List<WorkHistory> workHistories = workHistoryRepository.findByAdminUuid(adminUuid);

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writer().withRootName("workHistoryDetails").writeValueAsString(workHistories);
        JsonNode finalResult = mapper.readTree(result);
        if (workHistories.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Details Not Found", null);
        } else {

            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

    public Response shopDetails(String shopUuid) throws JsonProcessingException {

        List<WorkHistory> workHistories = workHistoryRepository.findByShopUuid(shopUuid);

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writer().withRootName("shopDetails").writeValueAsString(workHistories);
        JsonNode finalResult = mapper.readTree(result);
        if (workHistories.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Details Not Found", null);
        } else {

            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }


}
