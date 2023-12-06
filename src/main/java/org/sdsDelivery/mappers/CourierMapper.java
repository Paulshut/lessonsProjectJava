package org.sdsDelivery.mappers;

import org.sdsDelivery.entities.Courier;

import javax.servlet.http.HttpServletRequest;

import static org.sdsDelivery.utils.Constants.*;

public class CourierMapper {
    public Courier builderCourier(HttpServletRequest request) {
        return Courier.builder()
                .name(request.getParameter(NAME_COURIERS_PARAM))
                .surname(request.getParameter(SURNAME_COURIERS_PARAM))
                .contactPhone(request.getParameter(PHONE_COURIERS_PARAM))
                .build();
    }
}