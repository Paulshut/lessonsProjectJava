package org.sds.delivery.dto.requests.userRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UpdateUserRequest {
    @Null
    private String name;

    @Null
    private String surname;

    @Null
    @Email
    private String email;

    @Null
    @Pattern(regexp = "^\\+\\d{12}$")
    private String contactPhone;
}