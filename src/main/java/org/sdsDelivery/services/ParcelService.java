package org.sdsDelivery.services;

import org.sdsDelivery.entities.Parcel;

import static java.lang.Math.round;

public interface ParcelService {
    Parcel createParcel(Parcel parcel);

    public static int getRandomNumber() {
        return (int) round(Math.random() * 10000);
    }
}
