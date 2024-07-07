package dev.ardijorganxhi.shkruajshqip.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTopicRequest(@NotNull @NotBlank String title) {}
