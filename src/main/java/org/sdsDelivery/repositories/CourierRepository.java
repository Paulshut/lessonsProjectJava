package org.sdsDelivery.repositories;

import org.sdsDelivery.entities.Courier;

import java.util.List;

public interface CourierRepository {
    Courier createCourier(Courier courier);

    List<Courier> readCourier();

    boolean deleteCourier(Courier courier);

    Courier getCourierById(Long id);

    Courier updateCourier(Courier courier);
}