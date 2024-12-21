package com.lucaslima.products.infra.dataproviders;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.lucaslima.products.application.gateways.IdempotencyProductGateway;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class IdempotencyProductDataProvider implements IdempotencyProductGateway {

    private static final long MAXIMUM_SIZE = 10000;
    private static final long DURATION_IN_MINUTES = 10;
    private final Cache<String, String> cache;

    public IdempotencyProductDataProvider() {
        this.cache = Caffeine
                .newBuilder()
                .expireAfterWrite(DURATION_IN_MINUTES, TimeUnit.MINUTES)
                .maximumSize(MAXIMUM_SIZE)
                .build();
    }

    @Override
    public boolean isDuplicate(String idempotencyKey, String value) {
        var duplicate = cache.getIfPresent(idempotencyKey) != null;

        if (!duplicate) {
            cache.put(idempotencyKey, value);
        }

        return duplicate;
    }
}
