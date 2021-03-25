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

    public int addApplicant(Applicant applicant) {
        return applicantRepository.insertApplicant(applicant);
    }

    public List<Applicant> getAllApplicant() {
        return applicantRepository.selectAllApplicant();
    }

    public Optional<Applicant> getPersonById(int id) {
        return applicantRepository.selectApplicantById(id);
    }

    public int deletePerson(int id) {
        return applicantRepository.deleteApplicantById(id);
    }

    public int updatePerson(Applicant newApplicant, int id) {
        return applicantRepository.updateApplicantById(newApplicant, id);
    }
}
