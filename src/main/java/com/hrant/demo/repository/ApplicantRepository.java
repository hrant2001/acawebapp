package com.hrant.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicantRepository<T> {

    int insertApplicant(T t);

    List<T> selectAllApplicant();

    Optional<T> selectApplicantById(int id);

    int deleteApplicantById(int id);

    int updateApplicantById(T t, int id);


}
