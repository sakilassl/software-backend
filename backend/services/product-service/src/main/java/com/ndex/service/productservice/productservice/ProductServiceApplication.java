package com.ndex.service.productservice.productservice;

import com.ndex.service.productservice.productservice.config.PDFGenerator;
import com.ndex.service.productservice.productservice.pdfs.ProductPdf;
import com.ndex.service.productservice.productservice.pdfs.RatingPdf;
import com.ndex.service.productservice.productservice.pdfs.TransactionsPdf;
import com.ndex.service.productservice.productservice.pdfs.UserPdf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;


@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext ac =  SpringApplication.run(ProductServiceApplication.class, args);;
        UserPdf userPdf =ac.getBean("user-pdf",UserPdf.class);
        TransactionsPdf transactionsPdf = ac.getBean("transactions-pdf",TransactionsPdf.class);
        userPdf.generatePdfReport();
        transactionsPdf.generatePdfReport();
    }

}
