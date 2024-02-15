package org.sds.delivery.dto.responses.userResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDeleteResponse {
    private String userId;
}