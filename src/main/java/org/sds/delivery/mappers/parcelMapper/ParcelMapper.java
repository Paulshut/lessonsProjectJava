package org.sds.delivery.mappers.parcelMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sds.delivery.dto.requests.parcelRequest.AddParcelRequest;
import org.sds.delivery.dto.responses.parcelResponse.AddParcelResponse;
import org.sds.delivery.entities.Parcel;
import org.sds.delivery.entities.ParcelStatus;

@Mapper(componentModel = "spring")
public interface ParcelMapper {
    @Mapping(target = "parcelStatus", expression = "java(getDefaultStatus())")
    Parcel ParcelRequestToParcel(AddParcelRequest request);
    AddParcelResponse parcelToAddParcelResponse(Parcel parcel);
    default ParcelStatus getDefaultStatus() {
        return ParcelStatus.NOT_REGISTERED;
    }
}