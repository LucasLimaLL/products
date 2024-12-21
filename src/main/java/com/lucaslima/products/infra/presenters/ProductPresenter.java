package com.lucaslima.products.infra.presenters;


import com.lucaslima.products.api.rest.dto.ProductDto;
import com.lucaslima.products.core.entities.Product;
import com.lucaslima.products.core.factories.ProductFactory;

public class ProductPresenter {

    private static ProductPresenter productPresenter;

    private ProductPresenter() {
    }

    public static ProductPresenter getInstance() {
        return productPresenter == null ? new ProductPresenter() : productPresenter;
    }

    public ProductDto toDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCreatedAt());
    }

    public Product toDomain(ProductDto product) {
        return ProductFactory.getInstance().createProductWithIdNameDescriptionPriceCreateAt(product.id(), product.name(), product.description(), product.price(), product.createdAt());
    }
}
