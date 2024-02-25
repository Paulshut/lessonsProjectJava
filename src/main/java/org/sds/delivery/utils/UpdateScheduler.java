package org.sds.delivery.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sds.delivery.repositories.orderRepository.OrderRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateScheduler {
    private final OrderRepository orderRepository;
    private static final long FIXED_DELAY = 50000L;
    private static final String LOG_MESSAGE = "Scheduled running ";

    /***
     * The method updates the order status to IN_WORK, when all of its parcels are in the status REGISTERED
     */
    @Scheduled(fixedDelay = FIXED_DELAY)
    @Transactional
    public void updateOrder() {
        log.info(LOG_MESSAGE + LocalDateTime.now());
        orderRepository.updateOrderToInWorkWhenParcelStatusInRegistered();
    }
}