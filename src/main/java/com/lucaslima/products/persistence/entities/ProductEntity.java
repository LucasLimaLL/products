package com.lucaslima.products.persistence.entities;

import com.lucaslima.products.core.entities.Product;
import com.lucaslima.products.core.factories.ProductFactory;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Builder(setterPrefix = "with")
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private ZonedDateTime createdAt;

    public static ProductEntity toEntity(Product product) {
        return ProductEntity.builder()
                .withId(product.getId())
                .withName(product.getName())
                .withDescription(product.getDescription())
                .withPrice(product.getPrice())
                .withCreatedAt(product.getCreatedAt())
                .build();
    }

    public static Product toDomain(ProductEntity product) {
        return ProductFactory
                .getInstance()
                .createProductWithIdNameDescriptionPriceCreateAt(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getCreatedAt()
                );
    }
}
