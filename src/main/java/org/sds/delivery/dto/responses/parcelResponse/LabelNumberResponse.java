package org.sds.delivery.dto.responses.parcelResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LabelNumberResponse {
    private UUID labelNumber;
}