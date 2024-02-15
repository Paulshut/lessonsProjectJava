package org.sds.delivery.controllers.parcelController;

import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.requests.parcelRequest.AddParcelRequest;
import org.sds.delivery.dto.requests.parcelRequest.DeleteParcelRequest;
import org.sds.delivery.dto.responses.parcelResponse.AddParcelResponse;
import org.sds.delivery.dto.responses.parcelResponse.DeleteParcelResponse;
import org.sds.delivery.dto.responses.parcelResponse.RegistrationParcelResponse;
import org.sds.delivery.services.parcelService.ParcelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/parcel")
public class ParcelController {
    private final ParcelService parcelService;

    @PostMapping("/{orderId}")
    @ResponseStatus(CREATED)
    public @ResponseBody AddParcelResponse addParcel(@PathVariable Long orderId, @RequestBody AddParcelRequest request) {
        return parcelService.addParcel(orderId, request);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(OK)
    public @ResponseBody DeleteParcelResponse deleteParcelByParcelNum(@PathVariable Long orderId,
                                                                      @RequestBody DeleteParcelRequest request) {
        return parcelService.deleteParcelByParcelNum(orderId, request);
    }

    @PatchMapping("/{parcelNumber}")
    @ResponseStatus(OK)
    public @ResponseBody RegistrationParcelResponse scanParcel(@PathVariable Integer parcelNumber) {
        return parcelService.registrationParcel(parcelNumber);
    }
}