package com.carly.reservation.dto;

import lombok.NonNull;


public record ReservationCreateDto(
        @NonNull
        Long userId,
        @NonNull
        Long carId,
        @NonNull
        String startDate,
        @NonNull
        String endDate
) {
}
