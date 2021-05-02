package com.swasth.smartlaundry.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swasth.smartlaundry.constraints.CommonConstants;
import com.swasth.smartlaundry.entity.OrderGrid;
import com.swasth.smartlaundry.entity.OrderHistory;
import com.swasth.smartlaundry.entity.ShopOrderHistory;
import com.swasth.smartlaundry.entity.User;
import com.swasth.smartlaundry.entity.UserOrder;
import com.swasth.smartlaundry.model.Dashboard;
import com.swasth.smartlaundry.model.ProRefNumber;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.OrderGridRepository;
import com.swasth.smartlaundry.repository.ShopOrderHistoryRepository;
import com.swasth.smartlaundry.repository.UserOrderHistoryRepository;
import com.swasth.smartlaundry.repository.UserOrderRepository;
import com.swasth.smartlaundry.repository.UserRepository;
import com.swasth.smartlaundry.util.UuidGenarator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserOderService {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private ShopOrderHistoryRepository shoporderHistoryRepository;

    @Autowired
    private UserOrderHistoryRepository userOrderHistoryRepository;

    @Autowired
    private OrderGridRepository orderGridRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FcmService fcmService;

    public Response createOrder(UserOrder userOrder) throws Exception {

        try {

            userOrder.setUuid(UuidGenarator.gen(CommonConstants.ORDER_PREFIX));
            userOrder.setCreatedOn(new Date());
            userOrder.setStatus("placed");
            userOrderRepository.save(userOrder);

            OrderGrid orderGrid = BeanUtils.instantiateClass(OrderGrid.class);
            orderGrid.setShopUuid(userOrder.getShopUuid());

            Date date = new Date();
            Optional<OrderGrid> isThere = orderGridRepository.findByShopUuidAndCreatedOn(userOrder.getShopUuid(), date);
            if (isThere.isPresent()) {
                orderGrid.setUuid(isThere.get().getUuid());
                orderGrid.setTotalOrders(isThere.get().getTotalOrders() + 1);

            } else {
                orderGrid.setUuid(UuidGenarator.gen(CommonConstants.ORDERGRID_PREFIX));
                orderGrid.setTotalOrders(1);

            }

            orderGridRepository.save(orderGrid);

            Optional<User> custUuid = userRepository.findById(userOrder.getUserUuid());

            Map<String, String> orderData = new HashMap<String, String>();
            if (custUuid.isPresent()) {

                String msg = new StringBuffer().append("Hi ").append(custUuid.get().getFirstName()).append(", \n")
                        .append("your order has been placed successfully").toString();

                orderData.put("orderUuid", userOrder.getUuid());
                orderData.put("shopUuid", userOrder.getShopUuid());
                orderData.put("userUuid", userOrder.getUserUuid());
                //orderData.put("msg", msg);
                orderData.put("deviceType", custUuid.get().getDeviceType());

                fcmService.fireMessage(custUuid.get().getFcmKey(), msg, orderData, CommonConstants.NOTIFICATION_ORDER);

            }
            orderData.clear();
            Optional<User> shopUuid = userRepository.findById(userOrder.getShopUuid());

            if (shopUuid.isPresent()) {
                userRepository.findById(userOrder.getShopUuid());
                String msg = new StringBuffer().append("Hi ").append(shopUuid.get().getShopName()).append(", \n")
                        .append("you have received new order").toString();
                orderData.put("orderUuid", userOrder.getUuid());
                orderData.put("shopUuid", userOrder.getShopUuid());
                orderData.put("userUuid", userOrder.getUserUuid());
                orderData.put("deviceType", shopUuid.get().getDeviceType());
                fcmService.fireMessage(shopUuid.get().getFcmKey(), msg, orderData, CommonConstants.NOTIFICATION_ORDER);
            }

            return Response.createSuccess(true, HttpStatus.CREATED.value(), "your order has been placed successfully",
                    null);
        } catch (Exception e) {
            return Response.createError(false, HttpStatus.NOT_MODIFIED.value(), "Order not placed", null);
        }

    }

    public Response getAllOrdersForCustomer(String userUuid) throws Exception {

        List<OrderHistory> orderHistory = userOrderHistoryRepository.findByCustomerName(userUuid);

        if (orderHistory.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Details Not Found", orderHistory);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(Include.NON_NULL);

            String result = mapper.writer().withRootName("userOrderHistory").writeValueAsString(orderHistory);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

    public Response getAllOrdersForShop(String shopUuid) throws Exception {

        List<ShopOrderHistory> orderHistory = shoporderHistoryRepository.findByShopName(shopUuid);

        if (orderHistory.isEmpty()) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "Details Not Found", orderHistory);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            // mapper.setSerializationInclusion(Include.NON_NULL);

            String result = mapper.writer().withRootName("shopOrderHistory").writeValueAsString(orderHistory);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);

        }
    }

    public Response getDashboardForShop(Dashboard dashboard) throws Exception {

        userRepository.updateByFcmKey(dashboard.getFcmKey(), dashboard.getUserUuid());
        Date date = new Date();

        Optional<OrderGrid> orderHistory = orderGridRepository.findByShopUuidAndCreatedOn(dashboard.getUserUuid(), date);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);
        if (orderHistory.isPresent()) {

            Optional<ShopOrderHistory> latestOrder = shoporderHistoryRepository
                    .findLatestOrder(dashboard.getUserUuid());
            if (latestOrder.isPresent()) {
                orderHistory.get().setLatestOrder(latestOrder.get());

            }

            String result = mapper.writer().withRootName("shopDashboard").writeValueAsString(orderHistory.get());
            JsonNode finalResult = mapper.readTree(result);
            return Response.createSuccess(true, HttpStatus.OK.value(), "OK", finalResult);
        } else {
            OrderGrid grid = new OrderGrid();
            String result = mapper.writer().withRootName("shopDashboard").writeValueAsString(grid);
            JsonNode finalResult = mapper.readTree(result);
            return Response.createError(false, HttpStatus.OK.value(), "Dashboard details not found", finalResult);

        }
    }

    public Response addRefNumber(ProRefNumber proRefNumber) {

        try {

            userOrderRepository.updateByRefNumber(proRefNumber.getRefNumber(), proRefNumber.getOrderUuid());
            return Response.createSuccess(true, HttpStatus.OK.value(), "your order reference number added successfully",
                    null);
        } catch (Exception e) {
            return Response.createError(false, HttpStatus.NOT_MODIFIED.value(), "unable to add reference number", null);
        }
    }

}
