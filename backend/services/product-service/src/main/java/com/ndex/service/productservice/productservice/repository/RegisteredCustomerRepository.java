package com.ndex.service.productservice.productservice.repository;

import com.ndex.service.productservice.productservice.models.RegCustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredCustomerRepository extends JpaRepository <RegCustomerModel , String>{
}
