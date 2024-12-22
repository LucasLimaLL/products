package com.lucaslima.products.configuration;

import com.lucaslima.products.application.gateways.CreateProductGateway;
import com.lucaslima.products.application.gateways.IdempotencyProductGateway;
import com.lucaslima.products.application.services.CreateProductService;
import com.lucaslima.products.application.services.IdempotencyProductService;
import com.lucaslima.products.core.usecases.CreateProductUseCase;
import com.lucaslima.products.core.usecases.IdempotencyProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBeansConfiguration {

    @Bean
    public CreateProductUseCase beanCreateProductUseCase(CreateProductGateway createProductGateway) {
        return new CreateProductService(createProductGateway);
    }

    @Bean
    public IdempotencyProductUseCase beanIdempotencyProductUseCase(IdempotencyProductGateway idempotencyProductGateway) {
        return new IdempotencyProductService(idempotencyProductGateway);
    }
}
