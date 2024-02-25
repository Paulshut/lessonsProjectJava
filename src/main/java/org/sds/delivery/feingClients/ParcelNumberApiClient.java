package org.sds.delivery.feingClients;

import org.sds.delivery.dto.responses.parcelResponse.ParcelNumberResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "parcel-api", url = "${services.external.parcelApi.url}")
public interface ParcelNumberApiClient {
    @GetMapping
    ParcelNumberResponse getParcelNumber();
}