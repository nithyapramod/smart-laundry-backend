package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.model.Dashboard;
import com.swasth.smartlaundry.model.Login;
import com.swasth.smartlaundry.model.OrderInfo;
import com.swasth.smartlaundry.model.ResetPassword;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.model.ShopDataInput;
import com.swasth.smartlaundry.model.ShopRegistraion;
import com.swasth.smartlaundry.model.VerifyOtp;
import com.swasth.smartlaundry.services.CancelReasonService;
import com.swasth.smartlaundry.services.OderInfoServiceForPartner;
import com.swasth.smartlaundry.services.OtpService;
import com.swasth.smartlaundry.services.ShopDataService;
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
//@Tag(name = "Shop Services")
@RequestMapping("shop")
public class ShopController {

    @Autowired
    private UserService userService;

    @Autowired
    private OtpService otpService;

    @Autowired
    private ShopDataService shopDataService;

    @Autowired
    private UserOderService userOderService;

    @Autowired
    private OderInfoServiceForPartner oderInfoService;

    @Autowired
    private CancelReasonService cancelReasonService;

    @PostMapping
    public Response addUser(@RequestBody ShopRegistraion shopRegistraion) throws Exception {
        return userService.createShop(shopRegistraion);
    }

    @PutMapping
    public Response editUserDetails(@RequestBody ShopRegistraion shopRegistraion) throws Exception {
        return userService.editShopDetails(shopRegistraion);
    }

    @PostMapping("login")
    public Response userLogin(@RequestBody Login login) throws Exception {
        return userService.getUserDetails(login, 3);
    }

    @PatchMapping("restPassword")
    public Response restPassword(@RequestBody ResetPassword resetPassword) throws Exception {
        return userService.changePassword(resetPassword, 3);
    }

    @GetMapping("otp/{phoneNumber}")
    public Response fetchAllItems(@PathVariable String phoneNumber) throws Exception {
        return otpService.genarateShopOtp(phoneNumber);
    }

    @PostMapping("otp/verify")
    public Response verifyOtpStatus(@RequestBody VerifyOtp verifyOtp) throws Exception {
        return otpService.verifyShopOtpStatus(verifyOtp);
    }

    @GetMapping("shopData/{shopUuid}")
    public Response fetchShopData(@PathVariable String shopUuid) throws Exception {
        return shopDataService.getShopData(shopUuid);
    }

    @PostMapping("timeslots")
    public Response fetchShopData(@RequestBody ShopDataInput shopDataInput) throws Exception {
        return shopDataService.getTimeSlotsData(shopDataInput);
    }

    @GetMapping("orderHistory/{shopUuid}")
    public Response fetchorderHistoryData(@PathVariable String shopUuid) throws Exception {
        return userOderService.getAllOrdersForShop(shopUuid);
    }

    @PostMapping("dashboard")
    public Response fetchDashboardData(@RequestBody Dashboard dashboard) throws Exception {
        return userOderService.getDashboardForShop(dashboard);
    }

    @PostMapping("/orderInfo")
    public Response fetchOderData(@RequestBody OrderInfo orderInfo) throws Exception {
        return oderInfoService.getOrderInfo(orderInfo);
    }

    /*
     * @PostMapping("emp/processing/assign") public Response
     * empProcessingAssignOrder(@RequestBody OrderAssign orderAssign) throws
     * Exception { return empOrderAssign.empProcessingAssignOrder(orderAssign); }
     */

    @GetMapping("cancel/reasons")
    public Response cancelReason() throws Exception {
        return cancelReasonService.getAllReason(2);
    }

}
