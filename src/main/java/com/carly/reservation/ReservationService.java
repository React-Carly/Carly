package com.carly.reservation;

import com.carly.car.CarRepository;
import com.carly.reservation.dto.ReservationCreateDto;
import com.carly.reservation.dto.ReservationGetDto;
import com.carly.reservation.dto.ReservationMapper;
import com.carly.reservation.dto.ReservationUpdateDto;
import com.carly.user.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final ReservationMapper reservationMapper;

    public ReservationGetDto createReservation(@NotNull ReservationCreateDto reservationCreateDto) {
        var user = userRepository.getReferenceById(reservationCreateDto.userId());
        var car = carRepository.getReferenceById(reservationCreateDto.carId());
        var reservation = reservationMapper.toEntity(reservationCreateDto);
        reservation.setCar(car);
        user.addReservation(reservation);
        return reservationMapper
                .toDto(reservationRepository.save(reservation));
    }

    public List<ReservationGetDto> getAllReservations(Pageable pageable) {
        return reservationRepository.findAll(pageable).stream().map(reservationMapper::toDto).collect(Collectors.toList());
    }

    public List<ReservationGetDto> getAllReservations() {
        return reservationRepository.findAll().stream().map(reservationMapper::toDto).collect(Collectors.toList());
    }

    public ReservationGetDto getById(Long id) {
        return reservationMapper.toDto(reservationRepository.findById(id).orElseThrow());
    }

    public List<ReservationGetDto> getByUserId(Long userId) {
        return reservationRepository.findByUserId(userId).stream().map(reservationMapper::toDto).collect(Collectors.toList());
    }


    public List<ReservationGetDto> getByCarIdAndUserId(Long carId, Long userId) {
        if (userId == null) {
            return reservationRepository.findByCar_Id(carId).stream().map(reservationMapper::toDto).collect(Collectors.toList());
        } else if (carId == null) {
            return reservationRepository.findByUser_Id(userId).stream().map(reservationMapper::toDto).collect(Collectors.toList());
        } else {
            return reservationRepository.findByCar_IdAndUser_Id(carId, userId).stream().map(reservationMapper::toDto).collect(Collectors.toList());
        }
    }

    public ReservationGetDto updateReservation(Long id, ReservationUpdateDto reservationUpdateDto) {
        var reservation = reservationRepository.getReferenceById(id);
        reservationMapper.updateReservation(reservationUpdateDto, reservation);
        return reservationMapper.toDto(reservationRepository.save(reservation));
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
