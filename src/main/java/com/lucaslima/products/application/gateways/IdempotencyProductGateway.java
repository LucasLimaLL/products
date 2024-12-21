package com.lucaslima.products.application.gateways;

public interface IdempotencyProductGateway {

    boolean isDuplicate(String idempotencyKey, String value);
}
