package com.swasth.smartlaundry.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.swasth.smartlaundry.constraints.CommonConstants;
import com.swasth.smartlaundry.entity.OrderGrid;
import com.swasth.smartlaundry.entity.OtpStore;
import com.swasth.smartlaundry.entity.ShopVerification;
import com.swasth.smartlaundry.entity.User;
import com.swasth.smartlaundry.model.AdminRegistration;
import com.swasth.smartlaundry.model.AdminStatus;
import com.swasth.smartlaundry.model.Dashboard;
import com.swasth.smartlaundry.model.Login;
import com.swasth.smartlaundry.model.ResetPassword;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.model.ShopRegistraion;
import com.swasth.smartlaundry.model.UserRegistraion;
import com.swasth.smartlaundry.repository.OrderGridRepository;
import com.swasth.smartlaundry.repository.OtpRepository;
import com.swasth.smartlaundry.repository.ShopVerificationRepository;
import com.swasth.smartlaundry.repository.UserRepository;
import com.swasth.smartlaundry.util.UuidGenarator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private ShopVerificationRepository shopVerificationRepository;

    @Autowired
    private OrderGridRepository orderGridRepository;

    public Response createUser(UserRegistraion userRegistraion) throws Exception {

        User user = BeanUtils.instantiateClass(User.class);
        BeanUtils.copyProperties(userRegistraion, user);

        Optional<User> isUserExits = userRepository.findByPhoneNumber(user.getPhoneNumber(), user.getEmail(), 4);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        if (isUserExits.isPresent()) {
            otpRepository.updateByPhoneNumber(user.getPhoneNumber());
            isUserExits.get().setLoginStatus(2);
            String result = objectMapper.writer().withRootName("otpDetails").writeValueAsString(isUserExits.get());
            JsonNode finalResult = objectMapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        } else {

            user.setUuid(UuidGenarator.gen(CommonConstants.USER_PREFIX));
            user.setStatus("A");
            user.setUserType(4);
            user.setCreatedOn(new Date());
            user.setPassword("nopassword");
            // Faker faker = new Faker();
            user.setUserName(user.getFirstName() + "." + user.getLastName());
            userRepository.save(user);
            userRegistraion.setUuid(user.getUuid());
            userRegistraion.setLoginStatus(2);
            otpRepository.updateByPhoneNumber(user.getPhoneNumber());

            String result = objectMapper.writer().withRootName("otpDetails").writeValueAsString(userRegistraion);
            JsonNode finalResult = objectMapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.CREATED.value(), "user was successfully created",
                    finalResult);

        }

    }

    public Response editUserDetails(UserRegistraion userRegistraion) throws Exception {

        User user = BeanUtils.instantiateClass(User.class);
        BeanUtils.copyProperties(userRegistraion, user);

        Optional<User> oldUsrDetails = userRepository.findById(user.getUuid());
        if (oldUsrDetails.isPresent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            String oldData = objectMapper.writer().writeValueAsString(oldUsrDetails.get());
            User defaults = objectMapper.readValue(oldData, User.class);
            ObjectReader updater = objectMapper.readerForUpdating(defaults);
            String newData = objectMapper.writer().writeValueAsString(user);
            User merged = updater.readValue(newData);

            User result = userRepository.save(merged);

            if (result != null) {
                String resultW = objectMapper.writer().withRootName("userDetails").writeValueAsString(result);
                JsonNode finalResult = objectMapper.readTree(resultW);
                return Response.createSuccess(true, HttpStatus.RESET_CONTENT.value(),
                        "User details updated successfully", finalResult);
            } else {
                return Response.createError(false, HttpStatus.NOT_MODIFIED.value(), "User Details Not Modified", null);

            }
        } else {
            return Response.createError(false, HttpStatus.NO_CONTENT.value(), "User Details Not Found", null);
        }

    }

    public Response getUserDetails(Login login) throws Exception {
        Optional<User> user = userRepository.findByPhoneNumberAndPassword(login.getUserName(), login.getPassword());

        if (user.isPresent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(Include.NON_NULL);

            String result = objectMapper.writer().withRootName("userDetails").writeValueAsString(user.get());
            JsonNode finalResult = objectMapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        } else {
            return Response.createError(false, HttpStatus.NO_CONTENT.value(), "User Details Not Found", null);

        }

    }

    public Response getUserDetails(Login login, int userType) throws Exception {
        Optional<User> user = userRepository.findByPhoneNumberAndPassword(login.getUserName(), login.getPassword(),
                userType);

        if (user.isPresent()) {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            String result = objectMapper.writer().withRootName("userDetails").writeValueAsString(user.get());
            JsonNode finalResult = objectMapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        } else {
            return Response.createError(false, HttpStatus.NO_CONTENT.value(), "User Details Not Found", null);

        }

    }

    public Response changePassword(ResetPassword resetPassword, int userType) {

        if (!resetPassword.getPassword().equals(resetPassword.getConformpassword())) {
            return Response.createError(false, HttpStatus.OK.value(), "password and confirm password should be same",
                    null);

        }

        Optional<User> user = userRepository.findByPhoneNumberAndUserType(resetPassword.getPhoneNumber(), userType);

        if (user.isPresent()) {

            if (user.get().getPassword().equals(resetPassword.getPassword())) {
                return Response.createError(false, HttpStatus.OK.value(),
                        "new password should not be same as old password", null);

            }

            Integer result = userRepository.restUserPassword(resetPassword.getPhoneNumber(),
                    resetPassword.getPassword(), userType);
            if (result == 1) {
                return Response.createSuccess(true, HttpStatus.OK.value(), "password changed successfully", null);
            } else {
                return Response.createError(false, HttpStatus.NOT_MODIFIED.value(), "password not changed", null);

            }
        } else {
            return Response.createError(false, HttpStatus.NO_CONTENT.value(), "User Details Not Found", null);

        }
    }

    public Response createShop(ShopRegistraion shopRegistraion) throws Exception {

        User user = BeanUtils.instantiateClass(User.class);
        BeanUtils.copyProperties(shopRegistraion, user);
        Optional<User> isUserExits = userRepository.findByPhoneNumber(user.getPhoneNumber(), user.getEmail(), 3);

        if (isUserExits.isEmpty()) {

            user.setUuid(UuidGenarator.gen(CommonConstants.SHOP_PREFIX));
            user.setStatus("IA");
            user.setUserType(3);
            user.setCreatedOn(new Date());
            user.setUserName(user.getFirstName() + "." + user.getLastName());
            userRepository.save(user);
            OtpStore otpStore = BeanUtils.instantiateClass(OtpStore.class);
            otpStore.setPhoneNumber(user.getPhoneNumber());
            otpStore.setStatus(2);
            otpStore.setOtp("1234");
            otpRepository.save(otpStore);

            ShopVerification shopVerification = BeanUtils.instantiateClass(ShopVerification.class);
            shopVerification.setUuid(UuidGenarator.gen(CommonConstants.SHOP_VERIFICATION_PREFIX));
            shopVerification.setShopAddress(user.getAddress());
            shopVerification.setShopName(user.getShopName());
            shopVerification.setShopUuid(user.getUuid());
            shopVerification.setShopPhoneNumber(user.getPhoneNumber());
            shopVerification.setAdminUuid(user.getAdminUuid());
            shopVerification.setShStatus("pending");
            shopVerificationRepository.save(shopVerification);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(Include.NON_NULL);

            String resultW = objectMapper.writer().withRootName("shopDetails").writeValueAsString(user);
            JsonNode finalResult = objectMapper.readTree(resultW);
            return Response.createSuccess(true, HttpStatus.CREATED.value(), "Shop was successfully created",
                    finalResult);

        } else {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(),
                    "phone number/email associated with another shop", null);

        }

    }

    public Response getShopDetails(String shopUuid) throws Exception {

        Optional<User> oldUsrDetails = userRepository.findById(shopUuid);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);

        if (oldUsrDetails != null) {
            String resultW = objectMapper.writer().withRootName("shopDetails").writeValueAsString(oldUsrDetails);
            JsonNode finalResult = objectMapper.readTree(resultW);
            return Response.createSuccess(true, HttpStatus.RESET_CONTENT.value(), "Shop details", finalResult);
        } else {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Shop Details Not Found", null);

        }

    }

    public Response editShopDetails(ShopRegistraion shopRegistraion) throws Exception {
        User user = BeanUtils.instantiateClass(User.class);
        BeanUtils.copyProperties(shopRegistraion, user);

        Optional<User> oldUsrDetails = userRepository.findById(user.getUuid());
        if (oldUsrDetails.isPresent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            String oldData = objectMapper.writer().writeValueAsString(oldUsrDetails.get());
            User defaults = objectMapper.readValue(oldData, User.class);
            ObjectReader updater = objectMapper.readerForUpdating(defaults);
            String newData = objectMapper.writer().writeValueAsString(user);
            User merged = updater.readValue(newData);

            User result = userRepository.save(merged);

            if (result != null) {
                String resultW = objectMapper.writer().withRootName("shopDetails").writeValueAsString(result);
                JsonNode finalResult = objectMapper.readTree(resultW);
                return Response.createSuccess(true, HttpStatus.RESET_CONTENT.value(),
                        "Shop details updated successfully", finalResult);
            } else {
                return Response.createError(false, HttpStatus.NOT_MODIFIED.value(), "Shop Details Not Modified", null);

            }
        } else {
            return Response.createError(false, HttpStatus.NO_CONTENT.value(), "Shop Details Not Found", null);
        }

    }

    public Response getAllAdmins() throws Exception {

        List<User> adminList = userRepository.findByUserType(2);
        if (adminList.size() > 0) {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            String resultW = objectMapper.writer().withRootName("adminList").writeValueAsString(adminList);
            JsonNode finalResult = objectMapper.readTree(resultW);
            return Response.createSuccess(true, HttpStatus.OK.value(), "admin details", finalResult);

        } else {
            return Response.createError(false, HttpStatus.NO_CONTENT.value(), "admin Details Not Found", null);

        }

    }

    public Response createAdmin(AdminRegistration adminRegistration) throws Exception {

        User user = BeanUtils.instantiateClass(User.class);
        BeanUtils.copyProperties(adminRegistration, user);
        List<User> isUserExits = userRepository.findByPhoneNumberAndUserType(user.getPhoneNumber());

        if (isUserExits.isEmpty()) {

            user.setUuid(UuidGenarator.gen(CommonConstants.ADMIN_PREFIX));
            user.setStatus("A");
            user.setUserType(2);
            user.setCreatedOn(new Date());
            user.setUserName(user.getFirstName() + "." + user.getLastName());

            userRepository.save(user);

            return Response.createSuccess(true, HttpStatus.CREATED.value(), "Admin was successfully created", null);

        } else {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "user already exists", null);

        }

    }

    public Response getSuperDashboard(Dashboard dashboard) throws JsonProcessingException {

        userRepository.updateByFcmKey(dashboard.getFcmKey(), dashboard.getUserUuid());
        OrderGrid orderGrid = null;
        if (dashboard.getUserType() == 1) {
            orderGrid = orderGridRepository.findByCreatedOn();

        } else {
            orderGrid = orderGridRepository.findByAdminUuid(dashboard.getUserUuid());

        }
        if (orderGrid != null) {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            String resultW = objectMapper.writer().withRootName("dashboardDetails").writeValueAsString(orderGrid);
            JsonNode finalResult = objectMapper.readTree(resultW);
            return Response.createSuccess(true, HttpStatus.OK.value(), "success", finalResult);

        } else {
            return Response.createError(false, HttpStatus.NO_CONTENT.value(), "Dashboard details not found", null);

        }
    }

    public Response updateAdminStatus(AdminStatus av) {

        /**
         * status 1 means active status 2 means inactive
         */
        Integer status = 0;
        if (av.getStatus() == 2) {
            status = userRepository.updateByStatus("IA", av.getUserUuid());

            return Response.createSuccess(true, HttpStatus.OK.value(), "user status changed active to inactive", null);

        } else {
            status = userRepository.updateByStatus("A", av.getUserUuid());

            return Response.createError(true, HttpStatus.OK.value(), "user status changed inactive to active", null);

        }

    }
}
