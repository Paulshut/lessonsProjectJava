package org.sds.delivery.dto.requests.orderRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sds.delivery.entities.Address;
import org.sds.delivery.entities.OrderStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
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