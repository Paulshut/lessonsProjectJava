package org.sds.delivery.services.parcelService;

import org.sds.delivery.dto.requests.parcelRequest.AddParcelRequest;
import org.sds.delivery.dto.requests.parcelRequest.DeleteParcelRequest;
import org.sds.delivery.dto.responses.parcelResponse.AddParcelResponse;
import org.sds.delivery.dto.responses.parcelResponse.DeleteParcelResponse;
import org.sds.delivery.dto.responses.parcelResponse.RegistrationParcelResponse;

/**
 * Service for working with parcels.
 */
public interface ParcelService {

    /**
     * Adds a new parcel to the specified order.
     *
     * @param orderId the identifier of the order to which the parcel will be added
     * @param request the request containing information about the parcel to be added
     * @return the response about adding a parcel in the form AddParcelResponse, which contains the parcel number
     */
    AddParcelResponse addParcel(Long orderId, AddParcelRequest request);

    /**
     * Deletes a parcel from the specified order by its parcel number.
     *
     * @param orderId the identifier of the order from which the parcel will be deleted
     * @param request the request containing the parcel number of the parcel to be deleted
     * @return the response contains the success of the parcel deletion as a DeleteParcelResponse object
     */
    DeleteParcelResponse deleteParcelByParcelNum(Long orderId, DeleteParcelRequest request);

    /**
     * Registers a parcel by its parcel number.
     *
     * @param parcelNumber the number of the parcel to be registered
     * @return the response indicating the success of the parcel registration as a RegistrationParcelResponse object
     */
    RegistrationParcelResponse registrationParcel(Integer parcelNumber);
}