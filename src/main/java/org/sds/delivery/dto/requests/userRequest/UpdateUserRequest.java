package org.sds.delivery.dto.requests.userRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Email
    private String email;

    @Pattern(regexp = "^\\+\\d{12}$")
    private String contactPhone;
}