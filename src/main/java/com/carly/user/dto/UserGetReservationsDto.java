package com.carly.user.dto;

import com.carly.reservation.dto.ReservationGetDto;

import java.util.List;

public record UserGetReservationsDto(
        List<ReservationGetDto> reservations
) {
}
