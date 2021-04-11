package com.hrant.demo.controller;

import com.hrant.demo.model.Applicant;
import com.hrant.demo.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("applicants")
@RestController
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public Applicant addPerson(@Valid @NonNull @RequestBody Applicant applicant) {
        return applicantService.addApplicant(applicant);
    }

    @GetMapping
    public List<Applicant> getAllPeople() {
        return applicantService.getAllApplicant();
    }

    @GetMapping(path = "{id}")
    public Applicant getPersonById(@PathVariable("id") int id) {
        return applicantService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") int id) {
        applicantService.deletePerson(id);
    }

//    @PutMapping(path = "{id}")
//    public Applicant updatePerson(@Valid @NotNull @RequestBody Applicant applicantToUpdate, @PathVariable("id") int id) {
//        return applicantService.updatePerson(applicantToUpdate, id);
//    }
}
