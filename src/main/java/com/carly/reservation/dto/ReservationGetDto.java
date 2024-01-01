package com.carly.reservation.dto;

import java.time.LocalDate;


public record ReservationGetDto(
        Long id,
        LocalDate startDate,
        LocalDate endDate,

        Long userId,
        Long carId
) {
}
