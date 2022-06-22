package com.ndex.service.productservice.productservice.pdfs;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ndex.service.productservice.productservice.config.PDFGenerator;
import com.ndex.service.productservice.productservice.models.ProductModel;
import com.ndex.service.productservice.productservice.models.RegCustomerModel;
import com.ndex.service.productservice.productservice.repository.ProductRepository;
import com.ndex.service.productservice.productservice.repository.RegisteredCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component ("user-pdf")
public class UserPdf {
    @Autowired
    private RegisteredCustomerRepository eRepo;
    @Autowired
    private PDFGenerator pdfGenerator;


    private static Font COURIER = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
    private static Font COURIER_SMALL = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
    private static Font COURIER_SMALL_FOOTER = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

    public void generatePdfReport() {

        Document document = new Document();
        int noOfColumns = 5;
        try {
            PdfWriter.getInstance(document, new FileOutputStream(getPdfNameWithDate()));
            document.open();
            addLogo(document);
            addDocTitle(document);
            createTable(document, noOfColumns);
            addFooter(document);
            document.close();
            System.out.println("------------------Your PDF Report is ready!-------------------------");

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }

    }

    private void addLogo(Document document) {
        try {
            Image img = Image.getInstance(pdfGenerator.getLogoImgPath());
            img.scalePercent(pdfGenerator.getLogoImgScale()[0], pdfGenerator.getLogoImgScale()[1]);
            img.setAlignment(Element.ALIGN_RIGHT);
            document.add(img);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addDocTitle(Document document) throws DocumentException {
        String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(pdfGenerator.getLocalDateFormat()));
        String reportFileName = "User Report";
        Paragraph p1 = new Paragraph();
        leaveEmptyLine(p1, 1);
        p1.add(new Paragraph(reportFileName, COURIER));
        p1.setAlignment(Element.ALIGN_CENTER);
        leaveEmptyLine(p1, 1);
        p1.add(new Paragraph("Report generated on " + localDateString, COURIER_SMALL));

        document.add(p1);

    }

    private void createTable(Document document, int noOfColumns) throws DocumentException {
        noOfColumns = 5;
        Paragraph paragraph = new Paragraph();
        leaveEmptyLine(paragraph, noOfColumns);
        document.add(paragraph);
        java.util.List<String> columnNames = java.util.List.of("USER ID", "USER NAME", "EMAIL", "FIRST NAME", "LAST NAME");
        PdfPTable table = new PdfPTable(noOfColumns);

        for (int i = 0; i < noOfColumns; i++) {
            PdfPCell cell = new PdfPCell(new Phrase(columnNames.get(i)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(cell);
        }

        table.setHeaderRows(1);
        getDbData(table);
        document.add(table);
    }

    private void getDbData(PdfPTable table) {

        List<RegCustomerModel> list = eRepo.findAll();
        for (RegCustomerModel registerd_customer : list) {

            table.setWidthPercentage(100);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(registerd_customer.getSID());
            table.addCell(registerd_customer.getUser_name());
            table.addCell(registerd_customer.getEmail());
            table.addCell(registerd_customer.getFName());
            table.addCell(registerd_customer.getLName());

        }

    }

    private void addFooter(Document document) throws DocumentException {
        Paragraph p2 = new Paragraph();
        leaveEmptyLine(p2, 3);
        p2.setAlignment(Element.ALIGN_MIDDLE);
        p2.add(new Paragraph(
                "------------------------End Of " + "The Report" + "------------------------",
                COURIER_SMALL_FOOTER));

        document.add(p2);
    }

    private static void leaveEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private String getPdfNameWithDate() {
        String reportFileName = "User-Report";
        String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(pdfGenerator.getReportFileNameDateFormat()));
        return pdfGenerator.getPdfDir() + reportFileName + "-" + localDateString + ".pdf";
    }
}

