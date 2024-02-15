package org.sds.delivery.dto.requests.orderRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.sds.delivery.entities.Address;
import org.sds.delivery.entities.OrderStatus;
@Data
public class UpdateOrderRequest {
    @NotBlank
    private String senderName;

    @NotBlank
    private String receiverName;

    @Valid
    @NotNull
    private Address senderAddress;

    @Valid
    @NotNull
    private Address receiverAddress;

    @NotNull
    private OrderStatus orderStatus;
}
