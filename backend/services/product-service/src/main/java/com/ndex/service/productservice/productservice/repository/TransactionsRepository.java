package com.ndex.service.productservice.productservice.repository;

import com.ndex.service.productservice.productservice.models.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<TransactionModel,String> {
}
