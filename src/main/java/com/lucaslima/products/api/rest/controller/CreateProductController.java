package com.lucaslima.products.api.rest.controller;

import com.lucaslima.products.api.rest.dto.ProductDto;
import com.lucaslima.products.core.usecases.CreateProductUseCase;
import com.lucaslima.products.core.usecases.IdempotencyProductUseCase;
import com.lucaslima.products.infra.presenters.ProductPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;

@RestController
public class CreateProductController {

    private final CreateProductUseCase createProductUseCase;
    private final IdempotencyProductUseCase idempotencyProductUseCase;

    public CreateProductController(
            CreateProductUseCase createProductUseCase,
            IdempotencyProductUseCase idempotencyProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.idempotencyProductUseCase = idempotencyProductUseCase;
    }

    @RequestMapping(
            path = "/products",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<ProductDto> create(
            @RequestHeader Map<String, String> headers,
            @RequestBody ProductDto productDto) {

        var product = ProductPresenter.getInstance().toDomain(productDto);

        if (idempotencyProductUseCase.isDuplicate(headers) || idempotencyProductUseCase.isDuplicate(product)) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }

        createProductUseCase.create(product);

        final var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(ProductPresenter.getInstance().toDto(product));
    }
}
