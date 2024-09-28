package ru.hackathon.projectManagementApp.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Registration request")
public class SignUpRequest {
    @Schema(description = "Username", example = "Jon")
    @NotBlank(message = "Username can't be empty")
    private String username;
    @Schema(description = "Email", example = "jon@gmail.com")
    @NotBlank(message = "Email can't be empty")
    @Email(message = "Email must be in format like user@example.com")
    private String email;
    @Schema(description = "Password", example = "my_secret_password")
    @NotBlank(message = "Password can't be empty")
    private String password;
}
