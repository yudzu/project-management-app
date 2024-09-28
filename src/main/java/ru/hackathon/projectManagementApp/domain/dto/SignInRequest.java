package ru.hackathon.projectManagementApp.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Authentication request")
public class SignInRequest {
    @Schema(description = "Username", example = "Jon")
    @NotBlank(message = "Username can't be empty")
    private String username;
    @Schema(description = "Password", example = "my_1secret1_password")
    @NotBlank(message = "Password can't be empty")
    private String password;
}
