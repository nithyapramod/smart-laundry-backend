package com.swasth.smartlaundry.services;

import java.util.List;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.entity.CancelReason;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.CancelReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CancelReasonService {

    @Autowired
    private CancelReasonRepository cancelReasonRepository;

    public Response getAllReason(int reasonType) throws Exception {

        List<CancelReason> cancelReasons = cancelReasonRepository.findByReasonType(reasonType);

        if (cancelReasons.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "cancel reasons not found", null);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writer().withRootName("cancelReasons").writeValueAsString(cancelReasons);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

}
