package com.hrant.demo;

import com.hrant.demo.certificate.CertificateGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcaWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcaWebAppApplication.class, args);

        CertificateGenerator demoCertificate = new CertificateGenerator();
        demoCertificate.generateCertificate();
    }

}
