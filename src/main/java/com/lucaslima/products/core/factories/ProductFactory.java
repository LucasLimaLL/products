package com.lucaslima.products.core.factories;

import com.lucaslima.products.core.entities.Product;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class ProductFactory {

    private static ProductFactory productFactory;

    private ProductFactory() {
    }

    public static ProductFactory getInstance() {
        return productFactory == null ? new ProductFactory() : productFactory;
    }

    public Product createProductWithNameDescriptionPrice(String name, String description, BigDecimal price) {
        return new Product(null, name, description, price, null);
    }

    public Product createProductWithIdNameDescriptionPriceCreateAt(String id, String name, String description, BigDecimal price, ZonedDateTime createdAt) {
        return new Product(id, name, description, price, createdAt);
    }
}
