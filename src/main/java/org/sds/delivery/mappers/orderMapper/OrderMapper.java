package org.sds.delivery.mappers.orderMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sds.delivery.dto.requests.orderRequest.CreateOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.UpdateOrderRequest;
import org.sds.delivery.dto.responses.orderResponse.CreateOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.OrderDto;
import org.sds.delivery.entities.Order;
import org.sds.delivery.enums.OrderStatus;

import java.time.LocalDate;
import java.util.List;

import static java.lang.Math.round;
import static org.sds.delivery.enums.OrderStatus.CREATED;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "dateCreate", expression = "java(setCreateData())")
    @Mapping(target = "orderNumber", expression = "java(setOrderNumber())")
    @Mapping(target = "orderStatus", expression = "java(defaultOrderStatus())")
    Order parcelToParcelDTO(CreateOrderRequest request);

    CreateOrderResponse mapOrderToCreateOrderResponse(Order order);

    List<OrderDto> mapOrderToOrdersResponse(List<Order> orders);

    OrderDto mapOrderToOrderResponse(Order order);

    void mapUpdateOrderRequestToOrder(UpdateOrderRequest request, @MappingTarget Order order);

    default OrderStatus defaultOrderStatus() {
        return CREATED;
    }

    default Integer setOrderNumber() {
        int limitParam = 100000000;
        return (int) round(Math.random() * limitParam);
    }

    default LocalDate setCreateData() {
        return LocalDate.now();
    }
}