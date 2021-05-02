package com.swasth.smartlaundry.services;

import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.entity.OtpStore;
import com.swasth.smartlaundry.entity.User;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.model.VerifyOtp;
import com.swasth.smartlaundry.repository.OtpRepository;
import com.swasth.smartlaundry.repository.UserRepository;
import com.swasth.smartlaundry.util.SMSSender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SMSSender smsSender;

    public Response genarateShopOtp(String phoneNumber) throws Exception {

        /**
         * status 1 means not verified
         *
         * status 2 means verified
         */

        String regex = "(0/91)?[6-9][0-9]{9}";

        if (!phoneNumber.matches(regex)) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "please satisfy mobile number conditions",
                    null);
        }

        OtpStore otpStore = otpRepository.findByPhoneNumberAndStatus(phoneNumber, 1);
        ObjectMapper mapper = new ObjectMapper();
        OtpStore store = BeanUtils.instantiateClass(OtpStore.class);
        Random random = new Random();
        String otp = String.format("%04d", random.nextInt(10000));

        if (otpStore != null) {
            store.setOtp(otp);
            store.setPhoneNumber(phoneNumber);
            store.setStatus(1);
            otpRepository.save(store);
            smsSender.sendSms(phoneNumber, "your one time password (otp) for login".replaceAll("otp", otp));


        } else {

            store.setOtp(otp);
            store.setPhoneNumber(phoneNumber);
            store.setStatus(1);
            otpRepository.save(store);

            smsSender.sendSms(phoneNumber, "your one time password (otp) for login".replaceAll("otp", otp));

            Optional<User> isUserExits = userRepository.findByPhoneNumberAndUserType(phoneNumber, 3);

            if (isUserExits.isPresent()) {
                store.setStatus(2);
            }


        }

        String result = mapper.writer().withRootName("otpDetails").writeValueAsString(store);
        JsonNode finalResult = mapper.readTree(result);

        return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);
    }

    public Response verifyShopOtpStatus(VerifyOtp verifyOtp) throws Exception {

        Optional<OtpStore> otpStatus = otpRepository.findByPhoneNumberAndOtp(verifyOtp.getPhoneNumber(),
                verifyOtp.getOtp());
        ObjectMapper mapper = new ObjectMapper();

        if (otpStatus.isPresent()) {
            Optional<User> isUserExits = userRepository.findByPhoneNumberAndUserType(verifyOtp.getPhoneNumber(),
                    3);

            if (isUserExits.isPresent()) {
                otpStatus.get().setFirstName(isUserExits.get().getFirstName());
                otpStatus.get().setLastName(isUserExits.get().getLastName());
            }
            String result = mapper.writer().withRootName("otpDetails").writeValueAsString(otpStatus.get());
            JsonNode finalResult = mapper.readTree(result);

            return Response.createSuccess(true, HttpStatus.OK.value(), "otp verified successfully", finalResult);
        } else {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(),
                    "One Time Password (OTP) was not valid. Please try again", null);

        }

    }

    public Response genarateOtp(String phoneNumber) throws Exception {

        /**
         * status 1 means not verified
         *
         * status 2 means verified
         */

        String regex = "(0/91)?[6-9][0-9]{9}";

        if (!phoneNumber.matches(regex)) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "please satisfy mobile number conditions",
                    null);
        }

        OtpStore otpStore = otpRepository.findByPhoneNumberAndStatus(phoneNumber, 1);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);
        OtpStore store = BeanUtils.instantiateClass(OtpStore.class);
        Random random = new Random();
        String otp = String.format("%04d", random.nextInt(10000));
        if (otpStore != null) {
            store.setStatus(1);
            store.setOtp(otp);
            store.setPhoneNumber(phoneNumber);
            otpRepository.save(store);
            smsSender.sendSms(phoneNumber, "your one time password (otp) for login".replaceAll("otp", otp));

            String result = mapper.writer().withRootName("otpDetails").writeValueAsString(otpStore);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);
        } else {

            store.setOtp(otp);
            store.setPhoneNumber(phoneNumber);
            store.setStatus(1);
            otpRepository.save(store);
            smsSender.sendSms(phoneNumber, "your one time password (otp) for login".replaceAll("otp", otp));

            Optional<User> isUserExits = userRepository.findByPhoneNumberAndUserType(phoneNumber, 4);

            if (isUserExits.isPresent()) {
                store.setStatus(2);
                store.setOtp(otp);
                store.setPhoneNumber(phoneNumber);
                otpRepository.save(store);
                store.setUuid(isUserExits.get().getUuid());
                store.setFirstName(isUserExits.get().getFirstName());
                store.setLastName(isUserExits.get().getLastName());
                store.setEmail(isUserExits.get().getEmail());
            }

            String result = mapper.writer().withRootName("otpDetails").writeValueAsString(store);
            JsonNode finalResult = mapper.readTree(result);

            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

    public Response verifyOtpStatus(VerifyOtp verifyOtp) throws Exception {

        Optional<OtpStore> otpStatus = otpRepository.findByPhoneNumberAndOtp(verifyOtp.getPhoneNumber(),
                verifyOtp.getOtp());
        ObjectMapper mapper = new ObjectMapper();

        if (otpStatus.isPresent()) {
            Optional<User> isUserExits = userRepository.findByPhoneNumberAndUserType(verifyOtp.getPhoneNumber(),
                    4);

            if (isUserExits.isPresent()) {
                otpStatus.get().setUuid(isUserExits.get().getUuid());
                otpStatus.get().setFirstName(isUserExits.get().getFirstName());
                otpStatus.get().setLastName(isUserExits.get().getLastName());
                otpStatus.get().setEmail(isUserExits.get().getEmail());
            }
            String result = mapper.writer().withRootName("otpDetails").writeValueAsString(otpStatus.get());
            JsonNode finalResult = mapper.readTree(result);

            return Response.createSuccess(true, HttpStatus.OK.value(), "otp verified successfully", finalResult);
        } else {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(),
                    "One Time Password (OTP) was not valid. Please try again", null);

        }

    }

}
