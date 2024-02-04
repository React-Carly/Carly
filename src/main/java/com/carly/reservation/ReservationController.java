package com.carly.reservation;

import com.carly.reservation.dto.ReservationCreateDto;
import com.carly.reservation.dto.ReservationGetDto;
import com.carly.reservation.dto.ReservationUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ReservationGetDto createReservation(@RequestBody @Valid ReservationCreateDto reservationCreateDto) {
        return reservationService.createReservation(reservationCreateDto);
    }

    @GetMapping
    public List<ReservationGetDto> getAllReservations(@RequestParam(required = false) Long carId, @RequestParam(required = false) Long userId, @PageableDefault(size = 20) Pageable pageable) {
        if (carId == null && userId == null) return reservationService.getAllReservations(pageable);
        return reservationService.getByCarIdAndUserId(carId, userId);
    }

    @GetMapping("/count")
    public Integer getCount() {
        return reservationService.getAllReservations().toArray().length;
    }

    @GetMapping("/{id}")
    public ReservationGetDto getById(@PathVariable Long id) {
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
