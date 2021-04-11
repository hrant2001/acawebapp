package com.hrant.demo.controller;

import com.hrant.demo.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("certificate_generator")
@RestController
public class CertificateController {

    private final CertificateService certificateService;

    @Autowired
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping(path = "{id}")
    public void getApplicantCertificate(@PathVariable("id") int id) {
        certificateService.generateCertificate(id);
    }
}

