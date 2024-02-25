package org.sds.delivery.controllers.orderController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.requests.orderRequest.CancelOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.CreateOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.UpdateOrderRequest;
import org.sds.delivery.dto.responses.orderResponse.CancelOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.CreateOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.OrderDto;
import org.sds.delivery.services.orderService.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("{orderId}")
    public OrderDto getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("user/{userId}")
    public List<OrderDto> getOrderByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @PostMapping("{userId}")
    @ResponseStatus(CREATED)
    public CreateOrderResponse createOrder(@PathVariable Long userId, @Valid @RequestBody CreateOrderRequest request) {
        return orderService.createOrder(userId, request);
    }

    @PatchMapping("user/{userId}")
    public CancelOrderResponse cancelOrder(@PathVariable Long userId, @Valid @RequestBody CancelOrderRequest request) {
        return orderService.cancelOrder(userId, request);
    }

    @PatchMapping("{orderId}")
    public void updateOrder(@PathVariable Long orderId, @Valid @RequestBody UpdateOrderRequest request) {
        orderService.updateOrder(orderId, request);
    }
}