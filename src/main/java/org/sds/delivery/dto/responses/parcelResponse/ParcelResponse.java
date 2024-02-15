package org.sds.delivery.dto.responses.parcelResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sds.delivery.entities.ParcelStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParcelResponse {
    private Integer parcelNumber;
    private Double weight;
    private Double length;
    private Double width;
    private Double height;
    private ParcelStatus parcelStatus;
}