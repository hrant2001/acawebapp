package com.hrant.demo.service;

import com.hrant.demo.model.Applicant;
import com.hrant.demo.model.Course;
import com.hrant.demo.repository.ApplicantRepository;
import com.hrant.demo.repository.CourseRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.time.LocalDate;

@Service
public class CertificateService {

    private static final String FILE = "applicant_certificate.pdf";
    private static final Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);
    private static final Font introFont = new Font(Font.FontFamily.COURIER, 9,
            Font.NORMAL);

    private final ApplicantRepository applicantRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public CertificateService(ApplicantRepository applicantRepository, CourseRepository courseRepository) {
        this.applicantRepository = applicantRepository;
        this.courseRepository = courseRepository;
    }

    private static void addMetaData(Document document) {
        document.addTitle("Course certificate");
        document.addSubject("Certificate");
        document.addKeywords("Java, C++, courses");
        document.addAuthor("Hrant_Education");
        document.addCreator("Hrant_Education");
    }

    private void addTitlePage(Document document, int id) throws DocumentException {

        Paragraph preface = new Paragraph();
        Applicant applicant = applicantRepository.findById(id).orElse(null);
        Course course = courseRepository.findById(applicant.getCourse().getCourseId()).orElse(null);

        addEmptyLine(preface);
        Paragraph cTemp = new Paragraph("CERTIFICATE", titleFont);
        cTemp.setAlignment(Element.ALIGN_CENTER);
        preface.add(cTemp);

        addEmptyLine(preface);
        Paragraph iTemp = new Paragraph(
                course.getCourseName() + "\n", titleFont);
        iTemp.setAlignment(Element.ALIGN_CENTER);
        preface.add(iTemp);

        addEmptyLine(preface);
        Paragraph dTemp = new Paragraph(
                course.getDescription() + "\n",
                introFont);
        dTemp.setAlignment(Element.ALIGN_CENTER);
        preface.add(dTemp);

        addEmptyLine(preface);
        preface.add(new Paragraph("Applicant name - " + applicant.getApplicantName()));

        addEmptyLine(preface);
        preface.add(new Paragraph("Teacher name - " + course.getTeacherName()));

        addEmptyLine(preface);
        LocalDate startDate = LocalDate.parse(course.getStartDate());
        LocalDate endDate = LocalDate.parse(course.getEndDate());
        int durationInMonths = (endDate.getYear() - startDate.getYear()) * 12 + endDate.getMonthValue() - startDate.getMonthValue();
        preface.add(new Paragraph("Course duration - " + durationInMonths + " months"));

        addEmptyLine(preface);

        document.add(preface);
    }

    private static void addEmptyLine(Paragraph paragraph) {
        paragraph.add(new Paragraph(" "));
    }

    public void generateCertificate(int id) {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document, id);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
