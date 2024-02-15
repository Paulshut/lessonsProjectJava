package org.sds.delivery.services.parcelService;

import org.sds.delivery.dto.requests.parcelRequest.AddParcelRequest;
import org.sds.delivery.dto.requests.parcelRequest.DeleteParcelRequest;
import org.sds.delivery.dto.responses.parcelResponse.AddParcelResponse;
import org.sds.delivery.dto.responses.parcelResponse.DeleteParcelResponse;
import org.sds.delivery.dto.responses.parcelResponse.RegistrationParcelResponse;

public interface ParcelService {
    AddParcelResponse addParcel(Long orderId, AddParcelRequest request);

    DeleteParcelResponse deleteParcelByParcelNum(Long orderId, DeleteParcelRequest request);

    RegistrationParcelResponse registrationParcel(Integer parcelNumber);
}