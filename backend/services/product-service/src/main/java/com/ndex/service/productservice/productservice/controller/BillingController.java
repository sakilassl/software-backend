package com.ndex.service.productservice.productservice.controller;


import com.ndex.service.productservice.productservice.models.BillDetailsModel;
import com.ndex.service.productservice.productservice.service.BillingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/billing")
@Slf4j
@AllArgsConstructor

public class BillingController {
    private final BillingService billingService;

    @PostMapping
    public ResponseEntity<Object> addBillDetails(@RequestBody BillDetailsModel body) {
        log.info("HIT-/billing | POST");
        BillDetailsModel response = billingService.addBillDetails(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getBillingDetails(@PathVariable String userId) {
        log.info("HIT-/billing | GET");
        List<BillDetailsModel> response = billingService.getBillingDetails(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }




}
