package com.hrant.demo.service;

import com.hrant.demo.model.Applicant;
import com.hrant.demo.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant addApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    public List<Applicant> getAllApplicant() {
        return applicantRepository.findAll();
    }

    public Optional<Applicant> getPersonById(int id) {
        return applicantRepository.findById(id);
    }

    public void deletePerson(int id) {
        applicantRepository.deleteById(id);
    }

//    public Applicant updatePerson(Applicant newApplicant, int id) {
//        Applicant existingApplicant = applicantRepository.findById(id).orElse(null);
//        existingApplicant
//        return applicantRepository.save(newApplicant);
//    }
}
