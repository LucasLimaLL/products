package com.lucaslima.products.application.services;

import com.lucaslima.products.application.exceptions.IdempotencyKeyNotBeNullException;
import com.lucaslima.products.application.gateways.IdempotencyProductGateway;
import com.lucaslima.products.core.entities.Product;
import com.lucaslima.products.core.usecases.IdempotencyProductUseCase;

import java.util.Map;

public class IdempotencyProductService implements IdempotencyProductUseCase {


    private static final String IDEMPOTENCY_KEY = "Idempotency-Key";
    private final IdempotencyProductGateway idempotencyProductGateway;

    public IdempotencyProductService(IdempotencyProductGateway idempotencyProductGateway) {
        this.idempotencyProductGateway = idempotencyProductGateway;
    }

    @Override
    public boolean isDuplicate(Map<String, String> headers) {

        var idempotencyKey = headers
                .keySet()
                .stream()
                .filter(key -> key.equalsIgnoreCase(IDEMPOTENCY_KEY))
                .findAny();

        if (idempotencyKey.isEmpty()) {
            throw new IdempotencyKeyNotBeNullException();
        }

        var idempotencyKeyValue = headers.get(idempotencyKey.get());

        return idempotencyProductGateway.isDuplicate(idempotencyKeyValue, idempotencyKeyValue);
    }

    @Override
    public boolean isDuplicate(Product product) {
        return idempotencyProductGateway.isDuplicate(String.valueOf(product.hashCode()), product.toString());
    }
}
