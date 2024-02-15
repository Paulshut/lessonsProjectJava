package org.sds.delivery.dto.requests.parcelRequest;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteParcelRequest {
    @NotNull
    Integer parcelNumber;
}