package com.hrant.demo.repository;

import com.hrant.demo.model.Applicant;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;


@Repository
public class ApplicantRepositoryImpl implements ApplicantRepository<Applicant> {

    private final JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(ApplicantRepositoryImpl.class);

    @Autowired
    public ApplicantRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Applicant> rowMapper = (rs, rowNum) -> {
        Applicant applicant = new Applicant();
        applicant.setApplicantId(rs.getInt("applicant_id"));
        applicant.setApplicantName(rs.getString("applicant_name"));
        applicant.setEmail(rs.getString("email"));
        applicant.setPhoneNumber(rs.getString("phone_number"));
        applicant.setAddress(rs.getString("address"));
        applicant.setStatus(rs.getString("status"));
        return applicant;
    };

    @Override
    public List<Applicant> selectAllApplicant() {

        String sql = "SELECT * FROM applicants";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Applicant> selectApplicantById(int id) {
        String sql = "SELECT * FROM applicants WHERE applicant_id = ?";

        Applicant applicant = null;

        try {
            applicant = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);

        } catch (DataAccessException ex) {
            log.info("Applicant not found: " + id);

        }

        return Optional.ofNullable(applicant);
    }

    @Override
    public int insertApplicant(Applicant applicant) {
        String sql = "INSERT INTO applicants(applicant_name, email, phone_number, address, status) VALUES (?,?,?,?,?)";
        int insert = jdbcTemplate.update(sql, applicant.getApplicantName(), applicant.getEmail(), applicant.getPhoneNumber(),
                applicant.getAddress(), applicant.getStatus());
        if (insert == 1) {
            log.info("New Applicant Created: " + applicant.getApplicantName());
            return 0;
        }

        return 1;
    }

    @Override
    public int deleteApplicantById(int id) {
        String sql = "DELETE FROM applicants WHERE applicant_id = ?";
        int delete = jdbcTemplate.update(sql, id);
        if (delete == 1) {
            log.info("Applicant Deleted: " + id);
            return 0;
        }

        return 1;
    }

    @Override
    public int updateApplicantById(Applicant applicant, int id) {
        String sql = "update applicants set applicant_name = ?, email = ?, phone_number = ?, address = ?, status = ? where applicant_id = ?";
        int update = jdbcTemplate.update(sql, applicant.getApplicantName(), applicant.getEmail(), applicant.getPhoneNumber(), applicant.getAddress(), applicant.getStatus(), id);
        if (update == 1) {
            log.info("Applicant Updated: " + applicant.getApplicantName());
            return 0;
        }

        return 1;
    }
}
