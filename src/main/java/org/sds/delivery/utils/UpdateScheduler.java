package org.sds.delivery.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sds.delivery.repositories.orderRepository.OrderRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateScheduler {
    private final OrderRepository orderRepository;

    @Scheduled(fixedDelay = 50000)
    @Transactional
    public void updateOrder() {
        log.info("Scheduled running");
        orderRepository.updateOrderToInWork();
    }
}