package com.ndex.service.productservice.productservice.service.impl;

import com.ndex.service.productservice.productservice.pdfs.ProductPdf;
import com.ndex.service.productservice.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductPdf productPdfGenerator;

    @Override
    public ResponseEntity<Object> getProductReport() {
        HashMap<String, String> response = new HashMap<>();
        try {
            String downloadUrl = productPdfGenerator.generatePdfReport();
            response.put("downloadUrl", downloadUrl);
            return ResponseEntity.ok().body(response);
        }catch (Exception  e) {
            String errorMessage = e.getMessage();
            response.put("error", errorMessage);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
