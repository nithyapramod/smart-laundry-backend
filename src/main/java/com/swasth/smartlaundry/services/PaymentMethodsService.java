package com.swasth.smartlaundry.services;

import java.util.List;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.entity.PaymentMethods;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentMethodsService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public Response getPaymentMethods() throws Exception {

        List<PaymentMethods> paymentMethods = paymentMethodRepository.findByStatus("A");

        if (paymentMethods.isEmpty()) {
            return Response.createError(false, HttpStatus.OK.value(), "Details Not Found", null);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writer().withRootName("paymentMethodDetails").writeValueAsString(paymentMethods);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

}
