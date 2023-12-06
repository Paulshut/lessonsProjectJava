package org.sdsDelivery.services;

import org.sdsDelivery.entities.Courier;
import org.sdsDelivery.repositories.CourierRepository;
import org.sdsDelivery.repositories.CourierRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.sdsDelivery.utils.Constants.*;

public class CourierServiceImpl implements CourierService {
    private static CourierService courierService;
    private final CourierRepository courierRepository = CourierRepositoryImpl.getInstance();

    @Override
    public Courier createCourier(Courier courier) {
        return courierRepository.createCourier(courier);
    }

    public List<Courier> readCouriers() {
        return courierRepository.readCourier();
    }

    @Override
    public boolean deleteCourier(Courier courier) {
        return courierRepository.deleteCourier(courier);
    }

    @Override
    public Courier getCourierById(Long id) {
        return courierRepository.getCourierById(id);
    }

    @Override
    public Courier updateCourier(HttpServletRequest request) {
        Courier courier = courierRepository.getCourierById(Long.parseLong(request.getParameter(ID_COURIERS_PARAM)));
        courier.setName(request.getParameter(NAME_COURIERS_PARAM));
        courier.setSurname(request.getParameter(SURNAME_COURIERS_PARAM));
        courier.setContactPhone(request.getParameter(PHONE_COURIERS_PARAM));
        return courier;
    }

    public static CourierService getInstance() {
        if (courierService == null) {
            courierService = new CourierServiceImpl();
        }
        return courierService;
    }

    private CourierServiceImpl() {
    }
}