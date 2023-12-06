package org.sdsDelivery.services;

import org.sdsDelivery.entities.Courier;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CourierService {
    Courier createCourier(Courier courier);
    List<Courier> readCouriers();

    boolean deleteCourier(Courier courier);

    Courier getCourierById(Long id);

    Courier updateCourier (HttpServletRequest request);
}