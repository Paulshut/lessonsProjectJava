package org.sdsDelivery.mappers;

import org.sdsDelivery.entities.Parcel;
import org.sdsDelivery.services.ParcelService;

import javax.servlet.http.HttpServletRequest;

public class ParcelMapper {
    public Parcel buildParcel(HttpServletRequest request){
        return Parcel.builder()
                .number(ParcelService.getRandomNumber())
                .senderName(request.getParameter("senderName"))
                .receiverName(request.getParameter("receiverName"))
                .build();
    }
}
