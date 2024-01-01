package com.carly.reservation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class ReservationGetDto {
    private Long id;
    private LocalDate createdAt;
    private String startDate;
    private String endDate;

    private Long userId;
    private Long CarId;
}
