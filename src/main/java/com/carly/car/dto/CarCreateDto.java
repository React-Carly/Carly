package com.carly.car.dto;

import com.carly.car.FuelType;
import jakarta.validation.constraints.NotNull;

public record CarCreateDto(
        @NotNull String brand,
        @NotNull String model,
        @NotNull FuelType fuelType,
        @NotNull Integer mileage,
        @NotNull Short seats,
        @NotNull String color,
        @NotNull Integer year,
        @NotNull Integer pricePerHour,
        @NotNull String description
) {
}
