package org.sds.delivery.controllers.orderController;

import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.requests.orderRequest.CreateOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.CancelOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.UpdateOrderRequest;
import org.sds.delivery.dto.responses.orderResponse.CancelOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.CreateOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.OrderResponse;
import org.sds.delivery.services.orderService.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{orderId}")
    @ResponseStatus(OK)
    public OrderResponse getParcelById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/getOrders/{userId}")
    @ResponseStatus(OK)
    public @ResponseBody List<OrderResponse> getParcelByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @PostMapping("/{userId}")
    @ResponseStatus(CREATED)
    public @ResponseBody CreateOrderResponse createOrder(@PathVariable Long userId, @RequestBody CreateOrderRequest request) {
        return orderService.createOrder(userId, request);
    }

    @PatchMapping("/cancelOrder/{userId}")
    public @ResponseBody CancelOrderResponse cancelOrder(@PathVariable Long userId, @RequestBody CancelOrderRequest request) {
        return orderService.cancelOrder(userId, request);
    }

    @PatchMapping("/{orderId}")
    @ResponseStatus(OK)
    public void updateOrder(@PathVariable Long orderId, @RequestBody UpdateOrderRequest request) {
        orderService.updateOrder(orderId, request);
    }
}
