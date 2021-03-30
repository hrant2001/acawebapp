package com.hrant.demo.certificate;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class CertificateGenerator {

    private static String FILE = "certificate.pdf";
    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);
    private static Font introFont = new Font(Font.FontFamily.COURIER, 9,
            Font.NORMAL);

    private static void addMetaData(Document document) {
        document.addTitle("Course certificate");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Hrant Arakelyan");
        document.addCreator("Hrant Arakelyan");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();

        addEmptyLine(preface);
        Paragraph cTemp = new Paragraph("CERTIFICATE", titleFont);
        cTemp.setAlignment(Element.ALIGN_CENTER);
        preface.add(cTemp);

        addEmptyLine(preface);
        Paragraph iTemp = new Paragraph(
                "INTRODUCTION TO COMPUTER SCIENCE\n" , titleFont);
        iTemp.setAlignment(Element.ALIGN_CENTER);
        preface.add(iTemp);

        addEmptyLine(preface);
        Paragraph dTemp = new Paragraph(
                "Introduction to computer science and the study of algorithms; foundational ideas, computer organization, software concepts (e.g.,\n" +
                        "networking, databases, security); programming concepts using Java.\n",
                introFont);
        dTemp.setAlignment(Element.ALIGN_CENTER);
        preface.add(dTemp);

        addEmptyLine(preface);
        preface.add(new Paragraph("Applicant name - Poghos Petrosyan"));

        addEmptyLine(preface);
        preface.add(new Paragraph("Teacher name - Petros Poghosyan"));

        addEmptyLine(preface);
        preface.add(new Paragraph("Course duration - 4 months"));

        addEmptyLine(preface);

        document.add(preface);

        //document.newPage(); you can use this too
    }

    private static void addEmptyLine(Paragraph paragraph) {
        paragraph.add(new Paragraph(" "));
    }

    public void generateCertificate() {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
