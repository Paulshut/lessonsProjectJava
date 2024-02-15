package org.sds.delivery.dto.responses.parcelResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelNumberResponse {
    private UUID labelNumber;
}