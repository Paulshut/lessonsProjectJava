package org.sds.delivery.dto.responses.userResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
}