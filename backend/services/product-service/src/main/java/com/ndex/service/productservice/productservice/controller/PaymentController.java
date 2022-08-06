package com.ndex.service.productservice.productservice.controller;


import com.ndex.service.productservice.productservice.models.PaymentModel;
import com.ndex.service.productservice.productservice.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/payment")
@Slf4j
@AllArgsConstructor

public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Object> addPaymentDetails(@RequestBody PaymentModel body) {
        log.info("HIT-/payment | POST");
        PaymentModel response = paymentService.addPaymentDetails(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getPaymentDetails(@PathVariable String userId) {
        log.info("HIT-/payment | GET");
        List<PaymentModel> response = paymentService.getPaymentDetails(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
