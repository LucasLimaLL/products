package com.lucaslima.products.core.usecases;

import com.lucaslima.products.core.entities.Product;

import java.util.Map;

public interface IdempotencyProductUseCase {

    boolean isDuplicate(Map<String, String> headers);

    boolean isDuplicate(Product product);
}
