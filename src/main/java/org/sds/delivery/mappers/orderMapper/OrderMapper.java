package org.sds.delivery.mappers.orderMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sds.delivery.dto.requests.orderRequest.CreateOrderRequest;
import org.sds.delivery.dto.requests.orderRequest.UpdateOrderRequest;
import org.sds.delivery.dto.responses.orderResponse.CreateOrderResponse;
import org.sds.delivery.dto.responses.orderResponse.OrderResponse;
import org.sds.delivery.entities.Order;
import org.sds.delivery.entities.OrderStatus;

import java.time.LocalDate;
import java.util.List;

import static java.lang.Math.round;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "dateCreate", expression = "java(setCreateData())")
    @Mapping(target = "orderNumber", expression = "java(setOrderNumber())")
    @Mapping(target = "orderStatus", expression = "java(defaultOrderStatus())")
    Order parcelToParcelDTO(CreateOrderRequest request);

    default OrderStatus defaultOrderStatus() {
        return OrderStatus.CREATED;
    }
    default Integer setOrderNumber(){
        return (int) round(Math.random() * 100000000);
    }
    default LocalDate setCreateData(){
        return LocalDate.now();
    }

    CreateOrderResponse orderToCreateOrderResponse(Order order);
    List<OrderResponse> orderToOrdersResponse(List<Order> orders);

    OrderResponse orderToOrderResponse(Order order);

    Order updateOrderRequestToParcel(Long parcelId, UpdateOrderRequest request);
}