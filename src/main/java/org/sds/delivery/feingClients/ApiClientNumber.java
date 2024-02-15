package org.sds.delivery.feingClients;

import org.sds.delivery.dto.responses.parcelResponse.RandomNumberResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "api-client", url = "${services.external.apiNumber.url}")
public interface ApiClientNumber {
    @GetMapping
    RandomNumberResponse getRandomNumber();
}