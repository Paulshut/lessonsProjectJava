package org.sds.delivery.dto.responses.parcelResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddParcelResponse {
    private Integer parcelNumber;
}