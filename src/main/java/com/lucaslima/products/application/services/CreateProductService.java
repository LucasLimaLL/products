package com.lucaslima.products.application.services;

import com.lucaslima.products.application.gateways.CreateProductGateway;
import com.lucaslima.products.core.entities.Product;
import com.lucaslima.products.core.usecases.CreateProductUseCase;

public class CreateProductService implements CreateProductUseCase {

    private final CreateProductGateway createProductGateway;

    public CreateProductService(CreateProductGateway createProductGateway) {
        this.createProductGateway = createProductGateway;
    }

    @Override
    public Product create(Product product) {
        return createProductGateway.create(product);
    }
}
