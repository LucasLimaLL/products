package com.lucaslima.products.infra.dataproviders;

import com.lucaslima.products.application.gateways.CreateProductGateway;
import com.lucaslima.products.core.entities.Product;
import com.lucaslima.products.persistence.entities.ProductEntity;
import com.lucaslima.products.persistence.repositories.ProductRepostitory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateProductDataProvider implements CreateProductGateway {

    private final ProductRepostitory productRepostitory;

    public CreateProductDataProvider(ProductRepostitory productRepostitory) {
        this.productRepostitory = productRepostitory;
    }

    @Override
    public Product create(Product product) {

        product.withId(UUID.randomUUID().toString());
        var productEntity = productRepostitory.save(ProductEntity.toEntity(product));
        return ProductEntity.toDomain(productEntity);
    }
}
