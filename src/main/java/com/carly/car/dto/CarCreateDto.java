package com.carly.car.dto;

import lombok.NonNull;

public record CarCreateDto(
        @NonNull String name,
        @NonNull String model,
        @NonNull String color,
        @NonNull Integer year,
        @NonNull String description
) {
}
