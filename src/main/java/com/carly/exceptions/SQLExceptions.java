package com.carly.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import static com.carly.utils.ExceptionUtils.getErrorsMap;

@RestControllerAdvice
@Slf4j
public class SQLExceptions {
    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<Map<String, List<String>>> handleBadRequest(SQLIntegrityConstraintViolationException ex) {
        var errors = getErrorsMap(List.of(ex.getMessage()));
        return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
