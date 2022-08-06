package com.ndex.service.productservice.productservice.controller;

import com.ndex.service.productservice.productservice.service.ProductService;
import com.ndex.service.productservice.productservice.service.RatingService;
import com.ndex.service.productservice.productservice.service.TransactionService;
import com.ndex.service.productservice.productservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/report")
@AllArgsConstructor
public class ReportingController {

    private final ProductService productService;
    private final RatingService ratingService;
    private final TransactionService transactionService;
    private final UserService userService;


    @GetMapping("/product")
    public ResponseEntity<Object> getProductReport(){
        return productService.getProductReport();
    }

    @GetMapping("/rating")
    public ResponseEntity<Object> getRatingReport(){
        return ratingService.getRatingReport();
    }

    @GetMapping("/order_")
    public ResponseEntity<Object> getTransactionReport() { return transactionService.getTransactionReport();}

    @GetMapping("/registerd_customer")
    public ResponseEntity<Object> getUserReport() { return userService.getUserReport();}


}
