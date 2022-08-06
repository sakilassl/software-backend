package com.ndex.service.productservice.productservice.service.impl;


import com.ndex.service.productservice.productservice.models.PaymentModel;
import com.ndex.service.productservice.productservice.repository.PaymentRepository;
import com.ndex.service.productservice.productservice.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentModel addPaymentDetails(PaymentModel body) {
        body.setCreatedTime(new Date().getTime());
        return paymentRepository.save(body);
    }

    @Override
    public List<PaymentModel> getPaymentDetails(String userId) {
        return paymentRepository.findAllByUserId(userId);
    }


}
