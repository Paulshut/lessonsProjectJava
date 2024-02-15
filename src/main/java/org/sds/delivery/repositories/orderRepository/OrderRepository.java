package org.sds.delivery.repositories.orderRepository;

import org.sds.delivery.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {
    List<Order> getOrdersByUserId(Long userId);

    Optional<Order> getOrderById(Long parcelId);
}