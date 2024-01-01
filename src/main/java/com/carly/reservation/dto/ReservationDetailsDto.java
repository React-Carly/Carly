package com.carly.reservation.dto;

import com.carly.car.dto.CarGetDto;
import com.carly.user.dto.UserGetDto;

import java.time.LocalDate;

public record ReservationDetailsDto(
        Long id,
        LocalDate createdAt,
        LocalDate startDate,
        LocalDate endDate,

        UserGetDto user,
        CarGetDto car
) {
}
