package com.lucaslima.products.application.gateways;

import com.lucaslima.products.core.entities.Product;

public interface CreateProductGateway {

    Product create(Product product);
}
