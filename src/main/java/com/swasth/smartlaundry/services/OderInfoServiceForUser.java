package com.swasth.smartlaundry.services;

import javax.transaction.Transactional;

import com.swasth.smartlaundry.model.OrderInfo;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.OrderTrasactionRepository;
import com.swasth.smartlaundry.repository.UserAddressRepository;
import com.swasth.smartlaundry.repository.UserOrderHistoryRepository;
import com.swasth.smartlaundry.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OderInfoServiceForUser {

    @Autowired
    private UserOrderHistoryRepository userOrderHistoryRepository;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private UserOrderRepository orderRepository;

    @Autowired
    private OrderTrasactionRepository orderTrasactionRepository;


    public Response getOrderInfo(OrderInfo orderInfo) {

		/*try {

			OrderInfoDeatil deatil = BeanUtils.instantiateClass(OrderInfoDeatil.class);

			Optional<OrderHistory> orderData = userOrderHistoryRepository.findByUuid(orderInfo.getOrderUuid());
			if (orderData.isPresent()) {
				deatil.setUserOrderDeatil(orderData.get());
			}

			Optional<_EmpOrderHistory> assignTo = empOrderHistoryRepository.findByOrderUuidAndStatus(
					orderInfo.getOrderUuid(), CommonConstants.OrderStatus.completed.name(),
					CommonConstants.OrderStatus.ongoing.name(), CommonConstants.OrderStatus.pickup.name());
			
			Optional<UserOrder> userOrder = orderRepository.findById(orderInfo.getOrderUuid());

			if (assignTo.isPresent()) {
				if (userOrder.isPresent()) {
					Optional<UserAddress> userAddress = userAddressRepository
							.findById(userOrder.get().getUserAddressUuid());
					assignTo.get().setcAddress(userAddress.get().getAddress());
					assignTo.get().setcLat(userAddress.get().getLat());
					assignTo.get().setcLng(userAddress.get().getLng());
				}
				orderData.get().setAssignTo(assignTo.get());
			}
			Optional<_EmpOrderHistory> deliveredTo = empOrderHistoryRepository.findByOrderUuidAndStatus(orderInfo.getOrderUuid(),
					CommonConstants.OrderStatus.completed.name(),CommonConstants.OrderStatus.shipped.name()
					, CommonConstants.OrderStatus.delivered.name());
			if (deliveredTo.isPresent()) {
				if (userOrder.isPresent()) {
					Optional<UserAddress> userAddress = userAddressRepository
							.findById(userOrder.get().getUserAddressUuid());
					deliveredTo.get().setcAddress(userAddress.get().getAddress());
					deliveredTo.get().setcLat(userAddress.get().getLat());
					deliveredTo.get().setcLng(userAddress.get().getLng());
				}
				orderData.get().setDeliveredTo(deliveredTo.get());
			}
			
			
			
			
			List<OrderItems> orderItems = empOrderItemsRepository.findByOrderUuid(orderInfo.getOrderUuid());
			deatil.setOrderItems(orderItems);

 			deatil.setOrderQty(orderItems.size());
			Double orderValue = empOrderItemsRepository.totalOrderValue(orderInfo.getOrderUuid());
			deatil.setOrderValue(orderValue);

			Integer orderQtyValue = empOrderItemsRepository.totalQtyValue(orderInfo.getOrderUuid());
			deatil.setOrderQtyValue(orderQtyValue);

			if (!orderItems.isEmpty()) {
				deatil.setOrderItems(orderItems);
			}

			Optional<OrderTransaction> orderTransaction = orderTrasactionRepository
					.findByOrderUuid(orderInfo.getOrderUuid());
			if (orderTransaction.isPresent()) {
				deatil.setOrderTransaction(orderTransaction.get());
			}

			ObjectMapper objectMapper = new ObjectMapper();
			// objectMapper.setSerializationInclusion(Include.NON_NULL);

			String resultW = objectMapper.writer().withRootName("orderInfo").writeValueAsString(deatil);
			JsonNode finalResult = objectMapper.readTree(resultW);
			return Response.createSuccess(true, HttpStatus.OK.value(), "Order info details", finalResult);
		} catch (Exception e) {
			return Response.createError(false, HttpStatus.NO_CONTENT.value(), "Order info Details not found", null);
		}*/
        return null;
    }

}
