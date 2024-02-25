package org.sds.delivery.controllers.parcelController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.requests.parcelRequest.AddParcelRequest;
import org.sds.delivery.dto.requests.parcelRequest.DeleteParcelRequest;
import org.sds.delivery.dto.responses.parcelResponse.AddParcelResponse;
import org.sds.delivery.dto.responses.parcelResponse.DeleteParcelResponse;
import org.sds.delivery.dto.responses.parcelResponse.RegistrationParcelResponse;
import org.sds.delivery.services.parcelService.ParcelService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/parcel")
public class ParcelController {
    private final ParcelService parcelService;

    @PostMapping("{orderId}")
    @ResponseStatus(CREATED)
    public AddParcelResponse addParcel(@PathVariable Long orderId, @Valid @RequestBody AddParcelRequest request) {
        return parcelService.addParcel(orderId, request);
    }

    @DeleteMapping("{orderId}")
    public DeleteParcelResponse deleteParcelByParcelNum(@PathVariable Long orderId,
                                                        @Valid @RequestBody DeleteParcelRequest request) {
        return parcelService.deleteParcelByParcelNum(orderId, request);
    }

    @PatchMapping("{parcelNumber}")
    public RegistrationParcelResponse scanParcel(@PathVariable Integer parcelNumber) {
        return parcelService.registrationParcel(parcelNumber);
    }
}