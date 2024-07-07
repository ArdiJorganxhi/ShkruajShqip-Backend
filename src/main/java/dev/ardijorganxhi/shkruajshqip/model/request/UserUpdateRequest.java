package dev.ardijorganxhi.shkruajshqip.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserUpdateRequest(
        @NotNull @NotBlank String name,
        @NotNull @NotBlank String surname
) {}
