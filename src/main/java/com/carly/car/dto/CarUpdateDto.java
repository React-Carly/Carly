package com.carly.car.dto;

public record CarUpdateDto(
        String name,
        String model,
        String color,
        Integer year,
        String description) {
}
