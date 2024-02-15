package org.sds.delivery.services.orderService;

import org.sds.delivery.dto.requests.orderRequest.CancelOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.CreateOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.UpdateOrderRequest;
import org.sds.delivery.dto.responses.orderResponse.CancelOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.CreateOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse getOrderById(Long orderId);

    CreateOrderResponse createOrder(Long id, CreateOrderRequest request);

    List<OrderResponse> getOrdersByUserId(Long id);

    CancelOrderResponse cancelOrder(Long userId, CancelOrderRequest request);

    void updateOrder(Long orderId, UpdateOrderRequest request);
}