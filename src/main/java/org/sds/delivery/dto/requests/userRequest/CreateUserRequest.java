package org.sds.delivery.dto.requests.userRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.sds.delivery.entities.RoleUser;

@Data
public class CreateUserRequest {
    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Email
    private String email;

    @Pattern(regexp = "^\\+\\d{12}$")
    private String contactPhone;
}