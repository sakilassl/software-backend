package com.ndex.service.productservice.productservice.service.impl;
import com.ndex.service.productservice.productservice.pdfs.TransactionsPdf;
import com.ndex.service.productservice.productservice.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionsPdf transactionPdfGenerator;

    @Override
    public ResponseEntity<Object> getTransactionReport() {
        HashMap<String, String> response = new HashMap<>();
        try {
            String downloadUrl = transactionPdfGenerator.generatePdfReport();
            response.put("downloadUrl", downloadUrl);
            return ResponseEntity.ok().body(response);
        }catch (Exception  e) {
            String errorMessage = e.getMessage();
            response.put("error", errorMessage);
            return ResponseEntity.badRequest().body(response);
        }

    }
}


