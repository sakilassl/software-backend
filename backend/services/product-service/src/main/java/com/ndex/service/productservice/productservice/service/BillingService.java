package com.ndex.service.productservice.productservice.service;

import com.ndex.service.productservice.productservice.models.BillDetailsModel;

import java.util.List;

public interface BillingService {

    BillDetailsModel addBillDetails(BillDetailsModel body);

    List<BillDetailsModel> getBillingDetails(String userId);
}
