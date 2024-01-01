package com.carly.reservation;

import com.carly.reservation.dto.ReservationCreateDto;
import com.carly.reservation.dto.ReservationDetailsDto;
import com.carly.reservation.dto.ReservationGetDto;
import com.carly.reservation.dto.ReservationUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ReservationGetDto createReservation(@RequestBody ReservationCreateDto reservationCreateDto) {
        return reservationService.createReservation(reservationCreateDto);
    }

    @GetMapping
    public List<ReservationGetDto> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ReservationDetailsDto getById(@PathVariable Long id) {
        return reservationService.getById(id);
    }

    @PatchMapping("/{id}")
    public ReservationGetDto updateReservation(@PathVariable Long id, @RequestBody ReservationUpdateDto reservationUpdateDto) {
        return reservationService.updateReservation(id, reservationUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
