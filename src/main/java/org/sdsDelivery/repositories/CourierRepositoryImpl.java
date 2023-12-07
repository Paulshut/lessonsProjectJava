package org.sdsDelivery.repositories;

import org.sdsDelivery.entities.Courier;

import java.util.ArrayList;
import java.util.List;

public class CourierRepositoryImpl implements CourierRepository {
    private static CourierRepository courierRepository;

    List<Courier> couriers = new ArrayList<>(getTestCouriers());

    @Override public Courier createCourier(Courier courier) {
        courier.setId((long) couriers.size() + 1);
        couriers.add(courier);
        return courier;
    }

    @Override
    public List<Courier> readCourier() {
        return couriers;
    }

    @Override
    public boolean deleteCourier(Courier courier) {
        return couriers.remove(courier);
    }

    @Override
    public Courier getCourierById(Long id) {
        return couriers.stream()
                .filter(courier -> courier.getId().equals(id))
                .findAny()
                .get();

    }

    @Override
    public Courier updateCourier(Courier courier) {
        return courier;
    }

    List<Courier> getTestCouriers() {
        List<Courier> couriersTest = List.of(
                new Courier(1L,
                        "Ivan",
                        "Petrov",
                        "375292341001"),
                new Courier(2L,
                        "Aleksey",
                        "Ivanov",
                        "375292341002"),

                new Courier(3L,
                        "Petr",
                        "Sidorov",
                        "375292341002"));
        return couriersTest;
    }

    public static CourierRepository getInstance() {
        if (courierRepository == null) {
            courierRepository = new CourierRepositoryImpl();
        }
        return courierRepository;
    }

    private CourierRepositoryImpl() {
    }
}