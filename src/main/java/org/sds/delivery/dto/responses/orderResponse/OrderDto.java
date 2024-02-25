package org.sds.delivery.dto.responses.orderResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sds.delivery.dto.requests.orderRequest.AddressDto;
import org.sds.delivery.dto.responses.parcelResponse.ParcelDto;
import org.sds.delivery.enums.OrderStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer orderNumber;
    private String senderName;
    private String receiverName;
    private AddressDto senderAddress;
    private AddressDto receiverAddress;
    private OrderStatus orderStatus;
    private List<ParcelDto> parcels;
}