package org.sds.delivery.dto.requests.parcelRequest;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteParcelRequest {
    @NotNull
    Integer parcelNumber;
}