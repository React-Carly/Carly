package com.carly.utils;

import org.springframework.http.HttpStatus;

public record ExceptionDetails(HttpStatus status, String errorMessage) {
}
