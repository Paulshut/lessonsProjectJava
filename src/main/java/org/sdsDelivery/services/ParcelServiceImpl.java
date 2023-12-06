package org.sdsDelivery.services;

import org.sdsDelivery.entities.Parcel;

import static java.lang.Math.round;

public class ParcelServiceImpl implements ParcelService {
   private static ParcelService parcelService;
    @Override
    public Parcel createParcel(Parcel parcel) {
        return null;
    }
    public static ParcelService getInstance() {
        if (parcelService == null) {
            parcelService = new ParcelServiceImpl();
        }
        return parcelService;
    }

    private ParcelServiceImpl() {
    }
}
