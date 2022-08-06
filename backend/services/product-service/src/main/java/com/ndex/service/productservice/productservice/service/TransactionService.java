package com.ndex.service.productservice.productservice.service;


import org.springframework.http.ResponseEntity;

public interface TransactionService {
    ResponseEntity<Object> getTransactionReport();

}
