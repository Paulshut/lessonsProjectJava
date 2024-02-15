package org.sds.delivery.dto.responses.orderResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CancelOrderResponse {
    private Integer orderNumber;
}