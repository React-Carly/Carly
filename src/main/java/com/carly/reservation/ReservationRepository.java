package com.carly.reservation;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long id);

    List<Reservation> findByCar_IdAndUser_Id(Long carId, Long userId);

    List<Reservation> findByCar_Id(Long carId);

    List<Reservation> findByUser_Id(Long userId);
}
