package com.ndex.service.productservice.productservice.repository;

import com.ndex.service.productservice.productservice.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, String> {
}
