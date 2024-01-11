package com.carly.car.dto;

import com.carly.car.FuelType;

public record CarGetDto(
        Long id,
        String brand,
        String model,
        FuelType fuelType,
        Integer mileage,
        Short seats,
        String color,
        Integer year,
        Integer pricePerHour,
        String description,
        Double latitude,
        Double longitude
) {
}
