package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.entity.UserAddress;
import com.swasth.smartlaundry.entity.UserOrder;
import com.swasth.smartlaundry.model.Login;
import com.swasth.smartlaundry.model.NearBy;
import com.swasth.smartlaundry.model.OrderInfo;
import com.swasth.smartlaundry.model.ResetPassword;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.model.UserRegistraion;
import com.swasth.smartlaundry.model.VerifyOtp;
import com.swasth.smartlaundry.services.CancelReasonService;
import com.swasth.smartlaundry.services.FcmService;
import com.swasth.smartlaundry.services.NearByShopsService;
import com.swasth.smartlaundry.services.OderInfoServiceForUser;
import com.swasth.smartlaundry.services.OtpService;
import com.swasth.smartlaundry.services.UserAddressService;
import com.swasth.smartlaundry.services.UserOderService;
import com.swasth.smartlaundry.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Tag(name = "User Service")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private NearByShopsService nearByShopsService;

    @Autowired
    private UserOderService userOderService;

    @Autowired
    private OtpService otpService;

    @Autowired
    private OderInfoServiceForUser oderInfoServiceForUser;

    @Autowired
    private FcmService fcmService;

    @Autowired
    private CancelReasonService cancelReasonService;

    @PostMapping
    public Response addUser(@RequestBody UserRegistraion userRegistraion) throws Exception {
        return userService.createUser(userRegistraion);
    }

    @PutMapping
    public Response editUserDetails(@RequestBody UserRegistraion userRegistraion) throws Exception {
        return userService.editUserDetails(userRegistraion);
    }

    @PostMapping("login")
    public Response userLogin(@RequestBody Login login) throws Exception {
        return userService.getUserDetails(login, 4);
    }

    @PatchMapping("restPassword")
    public Response restPassword(@RequestBody ResetPassword resetPassword) throws Exception {
        return userService.changePassword(resetPassword, 4);
    }

    @PatchMapping("forgotPassword")
    public Response forgotPassword(@RequestBody ResetPassword resetPassword) throws Exception {
        return userService.changePassword(resetPassword, 4);
    }

    @PostMapping("nearByShops")
    public Response nearByShops(@RequestBody NearBy nearBy) throws Exception {
        return nearByShopsService.getNearByShops(nearBy);
    }

    @PostMapping("create/address")
    public Response createAddress(@RequestBody UserAddress userAddress) throws Exception {
        return userAddressService.createUserAddress(userAddress);
    }

    @GetMapping("address/{userId}")
    public Response getAddress(@PathVariable String userId) throws Exception {
        return userAddressService.getAllUserAddress(userId);
    }

    @PostMapping("place/order")
    public Response createOrder(@RequestBody UserOrder userOrder) throws Exception {
        return userOderService.createOrder(userOrder);
    }

    @GetMapping("otp/{phoneNumber}")
    public Response fetchAllItems(@PathVariable String phoneNumber) throws Exception {
        return otpService.genarateOtp(phoneNumber);
    }

    @PostMapping("otp/verify")
    public Response verifyOtpStatus(@RequestBody VerifyOtp verifyOtp) throws Exception {
        return otpService.verifyOtpStatus(verifyOtp);
    }

    @GetMapping("orderHistory/{userUuid}")
    public Response fetchorderHistoryData(@PathVariable String userUuid) throws Exception {
        return userOderService.getAllOrdersForCustomer(userUuid);
    }

    @PostMapping("orderInfo")
    public Response fetchOderInfoServiceForUserData(@RequestBody OrderInfo orderInfo) throws Exception {
        return oderInfoServiceForUser.getOrderInfo(orderInfo);
    }

    @GetMapping("fcm/{token}")
    public Response send(@PathVariable String token) throws Exception {
        return fcmService.fireMessage(token);
    }

    @GetMapping("cancel/reasons")
    public Response cancelReason() throws Exception {
        return cancelReasonService.getAllReason(1);
    }
}
