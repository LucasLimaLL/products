package com.lucaslima.products.api.rest.controller;

import com.lucaslima.products.api.rest.dto.ErrorDto;
import com.lucaslima.products.application.exceptions.IdempotencyKeyNotBeNullException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler({IdempotencyKeyNotBeNullException.class})
    public ResponseEntity<ErrorDto> handleIdempotencyKeyNotBeNullException(IdempotencyKeyNotBeNullException idempotencyKeyNotBeNullException) {
        return ResponseEntity
                .unprocessableEntity()
                .body(new ErrorDto(idempotencyKeyNotBeNullException.getLocalizedMessage()));
    }
}
