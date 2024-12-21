package com.lucaslima.products.application.exceptions;

public class IdempotencyKeyNotBeNullException extends IllegalArgumentException {

    public IdempotencyKeyNotBeNullException() {
        super("Idempotency key cannot be null or empty");
    }
}
