package com.ndex.service.productservice.productservice.service.impl;


import com.ndex.service.productservice.productservice.models.BillDetailsModel;
import com.ndex.service.productservice.productservice.repository.BillingRepository;
import com.ndex.service.productservice.productservice.service.BillingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;

    @Override
    public BillDetailsModel addBillDetails(BillDetailsModel body) {
        return billingRepository.save(body);
    }

    @Override
    public List<BillDetailsModel> getBillingDetails(String userId) {
        return billingRepository.findAllByUserId(userId);
    }

}
