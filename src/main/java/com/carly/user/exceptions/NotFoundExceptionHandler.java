package com.carly.user.exceptions;

import com.carly.utils.ExceptionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class NotFoundExceptionHandler {
    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<ExceptionDetails> handleNoSuchElement(NoSuchElementException ex) {
        log.error("No such elements Exception: {}", ex.getMessage());
        return new ResponseEntity<>(new ExceptionDetails(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}
