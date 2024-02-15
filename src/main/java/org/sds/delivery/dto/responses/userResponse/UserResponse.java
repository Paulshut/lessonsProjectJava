package org.sds.delivery.dto.responses.userResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String email;
    private String contactPhone;
}