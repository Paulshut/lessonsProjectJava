package org.sdsDelivery.repositories;

import org.sdsDelivery.entities.Parcel;

public class ParcelRepositoryImpl implements ParcelRepository {
    private static ParcelRepository parcelRepository;

    @Override
    public Parcel createParcel(Parcel parcel) {
        return null;
    }

    public static ParcelRepository getInstance() {
        if (parcelRepository == null) {
            parcelRepository = new ParcelRepositoryImpl();
        }
        return parcelRepository;
    }

    private ParcelRepositoryImpl() {
    }
}