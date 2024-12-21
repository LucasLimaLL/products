package com.lucaslima.products.api.rest.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public record ProductDto(String id, String name, String description, BigDecimal price, ZonedDateTime createdAt) {
}
