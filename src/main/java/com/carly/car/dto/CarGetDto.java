package com.carly.car.dto;

public record CarGetDto(
        Long id,
        String name,
        String model,
        String color,
        Integer year,
        String description
) {
}
