package com.carly.car.dto;

public record CarCreateDto(
        String name,
        String model,
        String color,
        Integer year,
        String description
) {
}
