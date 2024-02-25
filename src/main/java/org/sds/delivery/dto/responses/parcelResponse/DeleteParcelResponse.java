package org.sds.delivery.dto.responses.parcelResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteParcelResponse {
    Map<String, Integer> message;
}