package com.carly.reservation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ReservationDateValidator.class)
public @interface ReservationDateValidation {
    String message() default "Invalid dates selected";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
