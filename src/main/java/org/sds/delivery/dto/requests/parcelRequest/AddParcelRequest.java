package org.sds.delivery.dto.requests.parcelRequest;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddParcelRequest {
    @NotNull
    @Positive
    private Double weight;

    @NotNull
    @Positive
    private Double length;

    @NotNull
    @Positive
    private Double width;

    @NotNull
    @Positive
    private Double height;
}