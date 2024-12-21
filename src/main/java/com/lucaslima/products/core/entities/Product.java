package com.lucaslima.products.core.entities;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Product {

    private String id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private ZonedDateTime createdAt;

    public Product(String id, String name, String description, BigDecimal price, ZonedDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void withId(String id) {
        this.id = id;
        this.createdAt = ZonedDateTime.now();
    }
}
