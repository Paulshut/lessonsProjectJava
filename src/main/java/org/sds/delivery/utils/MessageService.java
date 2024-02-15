package org.sds.delivery.utils;

import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.responses.parcelResponse.DeleteParcelResponse;
import org.sds.delivery.dto.responses.parcelResponse.RegistrationParcelResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MessageService {
    private static final String PARCEL_SUCCESS_DELETED_MESSAGE_KEY = "parcel success deleted";
    private static final String PARCEL_SUCCESS_REGISTRATION_MESSAGE = "parcel success registration";

    public DeleteParcelResponse getMessageDeleted(Integer parcelNumber) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put(PARCEL_SUCCESS_DELETED_MESSAGE_KEY, parcelNumber);
        return new DeleteParcelResponse(stringIntegerMap);
    }

    public RegistrationParcelResponse getRegistrationResponse(UUID parcelLabel) {
        return new RegistrationParcelResponse(PARCEL_SUCCESS_REGISTRATION_MESSAGE, parcelLabel);
    }
}