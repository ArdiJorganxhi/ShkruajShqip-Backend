package dev.ardijorganxhi.shkruajshqip.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(
        @NotNull @NotBlank String username,
        @NotNull @NotBlank String name,
        @NotNull @NotBlank String surname,
        @NotNull @NotBlank @Email String email,
        @NotNull @NotBlank String password
) {}
