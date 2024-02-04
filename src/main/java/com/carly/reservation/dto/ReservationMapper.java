package com.carly.reservation.dto;

import com.carly.reservation.Reservation;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ReservationMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "carId", source = "car.id")
    ReservationGetDto toDto(Reservation reservation);

    Reservation toEntity(ReservationCreateDto reservationCreateDto);

    void updateReservation(ReservationUpdateDto sourceReservationDto, @MappingTarget Reservation targetReservation);
}
