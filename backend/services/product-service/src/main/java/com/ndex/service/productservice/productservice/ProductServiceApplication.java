package com.ndex.service.productservice.productservice;

import com.ndex.service.productservice.productservice.config.PDFGenerator;
import com.ndex.service.productservice.productservice.pdfs.ProductPdf;
import com.ndex.service.productservice.productservice.pdfs.RatingPdf;
import com.ndex.service.productservice.productservice.pdfs.TransactionsPdf;
import com.ndex.service.productservice.productservice.pdfs.UserPdf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        ApplicationContext ac =  SpringApplication.run(ProductServiceApplication.class, args);
        RatingPdf ratingPdf = ac.getBean("rating-pdf",RatingPdf.class);
        ProductPdf productPdf = ac.getBean("product-pdf",ProductPdf.class);
        UserPdf userPdf =ac.getBean("user-pdf",UserPdf.class);
        TransactionsPdf transactionsPdf = ac.getBean("transactions-pdf",TransactionsPdf.class);
        ratingPdf.generatePdfReport();
        productPdf.generatePdfReport();
        userPdf.generatePdfReport();
        transactionsPdf.generatePdfReport();
    }

}
