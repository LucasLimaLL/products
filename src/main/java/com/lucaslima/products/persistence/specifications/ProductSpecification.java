package com.lucaslima.products.persistence.specifications;

import com.lucaslima.products.persistence.entities.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.ZonedDateTime;

public class ProductSpecification {

    public static Specification<ProductEntity> hasCreatedAtBetween(ZonedDateTime start, ZonedDateTime end) {
        return (root, query, criteriaBuilder) -> {
            if (start == null || end == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.between(root.get("createdAt"), start, end);
        };
    }
}
