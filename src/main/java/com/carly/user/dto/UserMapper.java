package com.carly.user.dto;


import com.carly.reservation.dto.ReservationMapper;
import com.carly.user.User;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Autowired
    private ReservationMapper reservationMapper;

    public abstract UserGetDto toUDto(User user);

    public UserGetReservationsDto toReservationsDto(User user) {
        return new UserGetReservationsDto(user.getReservations().stream().map(reservationMapper::toDto).toList());
    }
}
