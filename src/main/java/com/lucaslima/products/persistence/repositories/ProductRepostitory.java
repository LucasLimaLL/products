package com.lucaslima.products.persistence.repositories;

import com.lucaslima.products.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepostitory extends JpaRepository<ProductEntity, Integer>, JpaSpecificationExecutor<ProductEntity> {
}
