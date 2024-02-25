package org.sds.delivery.services.orderService;

import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.requests.orderRequest.CancelOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.CreateOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.UpdateOrderRequest;
import org.sds.delivery.dto.responses.orderResponse.CancelOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.CreateOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.OrderDto;
import org.sds.delivery.entities.Order;
import org.sds.delivery.entities.User;
import org.sds.delivery.exceptions.OrderNotFoundException;
import org.sds.delivery.exceptions.UserNotFoundException;
import org.sds.delivery.mappers.orderMapper.OrderMapper;
import org.sds.delivery.repositories.orderRepository.OrderRepository;
import org.sds.delivery.repositories.userRepository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional(readOnly = true)
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.getOrderById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId.toString()));
        return orderMapper.mapOrderToOrderResponse(order);
    }

    @Override
    @Transactional
    public CreateOrderResponse createOrder(Long userId, CreateOrderRequest createOrderRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId.toString()));
        Order order = orderMapper.parcelToParcelDTO(createOrderRequest);
        order.setUser(user);
        orderRepository.save(order);
        return orderMapper.mapOrderToCreateOrderResponse(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getOrdersByUserId(Long userId) {
        List<Order> ordersByUserId = orderRepository.getOrdersByUserId(userId);
        return orderMapper.mapOrderToOrdersResponse(ordersByUserId);
    }

    @Override
    @Transactional
    public CancelOrderResponse cancelOrder(Long userId, CancelOrderRequest request) {
        orderRepository.updateOrderStatusByUserIdAndOrderNumberAndStatusInWorkOrCreated(userId, request.getOrderNumber());
        return new CancelOrderResponse(request.getOrderNumber());
    }

    @Override
    @Transactional
    public void updateOrder(Long orderId, UpdateOrderRequest request) {
        Order order = orderRepository.getOrderById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId.toString()));
        orderMapper.mapUpdateOrderRequestToOrder(request, order);
    }
}