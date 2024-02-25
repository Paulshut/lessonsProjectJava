package org.sds.delivery.repositories.orderRepository;

public interface OrderRepositoryCustom {
    void updateOrderStatusByUserIdAndOrderNumberAndStatusInWorkOrCreated(Long userId, Integer orderNumber);
    void updateOrderToInWorkWhenParcelStatusInRegistered();
}