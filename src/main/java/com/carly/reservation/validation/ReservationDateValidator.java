package com.carly.reservation.validation;

import com.carly.reservation.dto.ReservationCreateDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class ReservationDateValidator implements ConstraintValidator<ReservationDateValidation, ReservationCreateDto> {


    @Override
    public void initialize(ReservationDateValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ReservationCreateDto reservationCreateDto, ConstraintValidatorContext context) {
        var startBeforeEnd = !reservationCreateDto.startDate().isAfter(reservationCreateDto.endDate());
        var startAfterNow = !reservationCreateDto.startDate().isBefore(LocalDate.now());

        if (!startBeforeEnd) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Start date after end").addConstraintViolation();
        }
        if (!startAfterNow) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Start date before today").addConstraintViolation();
        }

        return startBeforeEnd && startAfterNow;
    }
}
