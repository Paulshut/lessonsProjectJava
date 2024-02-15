package org.sds.delivery.repositories.orderRepository;

public interface OrderRepositoryCustom {
    void updateOrderByUserIdAndOrderNumberAndStatusIn(Long userId, Integer orderNumber);
    void updateOrderToInWork();
}
