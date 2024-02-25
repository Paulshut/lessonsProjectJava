package org.sds.delivery.dto.requests.orderRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateOrderRequest {
    @NotBlank
    private String senderName;

    @NotBlank
    private String receiverName;

    @Valid
    @NotNull
    private AddressDto senderAddress;

    @Valid
    @NotNull
    private AddressDto receiverAddress;
}