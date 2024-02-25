package org.sds.delivery.feingClients;

import org.sds.delivery.dto.responses.parcelResponse.LabelNumberResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "label-api", url = "${services.external.labelApi.url}")
public interface LabelApiClient {

    @GetMapping("/{number}")
    LabelNumberResponse getLabelNumber(@PathVariable Integer number);
}