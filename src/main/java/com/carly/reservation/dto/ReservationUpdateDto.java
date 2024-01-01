package com.carly.reservation.dto;

import java.time.LocalDate;

public record ReservationUpdateDto(
        Long userId,
        Long carId,
        LocalDate startDate,
        LocalDate endDate
) {
}
