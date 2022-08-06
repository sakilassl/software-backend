package com.ndex.service.productservice.productservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pdfGenerator")
public class PDFGenerator {
    @Value("${env.pdf-gen.pdfDir}")
    private String pdfDir;

    @Value("${env.pdf-gen.reportFileNameDateFormat}")
    private String reportFileNameDateFormat;

    @Value("${env.pdf-gen.localDateFormat}")
    private String localDateFormat;

    @Value("${env.pdf-gen.logoImgPath}")
    private String logoImgPath;

    @Value("${env.pdf-gen.logoImgScale}")
    private Float[] logoImgScale;

    public String getPdfDir() {
        return pdfDir;
    }

    public String getReportFileNameDateFormat() {
        return reportFileNameDateFormat;
    }

    public String getLocalDateFormat() {
        return localDateFormat;
    }

    public String getLogoImgPath() {
        return logoImgPath;
    }

    public Float[] getLogoImgScale() {
        return logoImgScale;
    }
}