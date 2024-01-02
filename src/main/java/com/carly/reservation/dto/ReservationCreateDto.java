package com.carly.reservation.dto;

import com.carly.reservation.validation.ReservationDateValidation;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@ReservationDateValidation
public record ReservationCreateDto(
        @NotNull(message = "User id cannot be null")
        Long userId,
        @NotNull(message = "Car id cannot be null")
        Long carId,
        @NotNull(message = "Start date cannot be null")
        LocalDate startDate,
        @NotNull(message = "End date cannot be null")
        LocalDate endDate
) {
}
