package com.ndex.service.productservice.productservice.repository;


import com.ndex.service.productservice.productservice.models.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentModel, String> {

    List<PaymentModel> findAllByUserId(String userId);

}
