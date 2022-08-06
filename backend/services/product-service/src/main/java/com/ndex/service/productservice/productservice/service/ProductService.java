package com.ndex.service.productservice.productservice.service;

import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<Object> getProductReport();
}
