package com.carly.reservation.dto;

import com.carly.reservation.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "carId", source = "car.id")
    ReservationGetDto toDto(Reservation reservation);

    Reservation toEntity(ReservationCreateDto reservationCreateDto);
}
