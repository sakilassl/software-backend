package com.ndex.service.productservice.productservice.service.impl;

import com.ndex.service.productservice.productservice.pdfs.TransactionsPdf;
import com.ndex.service.productservice.productservice.pdfs.UserPdf;
import com.ndex.service.productservice.productservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPdf userPdfGenerator;

    @Override
    public ResponseEntity<Object> getUserReport() {
        HashMap<String, String> response = new HashMap<>();

        try {
            String downloadUrl = userPdfGenerator.generatePdfReport();
            response.put("downloadUrl", downloadUrl);
            return ResponseEntity.ok().body(response);
        }catch (Exception  e) {
            String errorMessage = e.getMessage();
            response.put("error", errorMessage);
            return ResponseEntity.badRequest().body(response);
        }

    }
}
