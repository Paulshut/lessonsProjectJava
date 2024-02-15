package org.sds.delivery.dto.responses.orderResponse;

import lombok.Data;
import org.sds.delivery.dto.responses.parcelResponse.ParcelResponse;
import org.sds.delivery.entities.Address;
import org.sds.delivery.entities.OrderStatus;

import java.util.List;

@Data
public class OrderResponse {
    private Integer orderNumber;
    private String senderName;
    private String receiverName;
    private Address senderAddress;
    private Address receiverAddress;
    private OrderStatus orderStatus;
    private List<ParcelResponse> parcels;
}