package org.sdsDelivery.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parcel {
    private int number;
    private Long id;
    private String senderName;
    private String receiverName;
    private Address senderAddress;
    private Address receiverAddress;
    private User user;
}