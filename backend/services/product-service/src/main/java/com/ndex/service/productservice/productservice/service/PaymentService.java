package com.ndex.service.productservice.productservice.service;

import com.ndex.service.productservice.productservice.models.PaymentModel;

import java.util.List;

public interface PaymentService {
    PaymentModel addPaymentDetails(PaymentModel body);
    List<PaymentModel> getPaymentDetails(String userId);
}
