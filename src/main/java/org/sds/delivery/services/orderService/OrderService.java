package org.sds.delivery.services.orderService;

import org.sds.delivery.dto.requests.orderRequest.CancelOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.CreateOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.UpdateOrderRequest;
import org.sds.delivery.dto.responses.orderResponse.CancelOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.CreateOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.OrderDto;

import java.util.List;

/**
 * Service for working with orders.
 */
public interface OrderService {
    /***
     * Retrieves information about an order by its identifier.
     * @param orderId the identifier of the order
     * @return information about the order as an OrderDto
     */
    OrderDto getOrderById(Long orderId);

    /**
     * Creates a new order based on the provided data.
     *
     * @param userId  the identifier of the user creating the order
     * @param request the request for creating the order
     * @return the response about the creation of the order as a CreateOrderResponse
     */
    CreateOrderResponse createOrder(Long userId, CreateOrderRequest request);

    /**
     * Retrieves a list of orders for the specified user.
     *
     * @param userId the identifier of the user
     * @return the list of user's orders as OrderDto objects
     */
    List<OrderDto> getOrdersByUserId(Long userId);

    /**
     * Cancels an order by changing the order status making it canceled
     *
     * @param userId  the identifier of the user
     * @param request the request for canceling the order
     * @return the response about the order cancellation as a CancelOrderResponse object
     */
    CancelOrderResponse cancelOrder(Long userId, CancelOrderRequest request);

    /**
     * Updates information about an order.
     *
     * @param orderId the identifier of the order
     * @param request the request for updating information about the order
     */
    void updateOrder(Long orderId, UpdateOrderRequest request);
}