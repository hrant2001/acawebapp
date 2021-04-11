package com.hrant.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="applicants")
public class Applicant {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="applicant_id")
    private int applicantId;

    @Column(name="applicant_name")
    private String applicantName;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="address")
    private String address;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Applicant() {
    }

    public Applicant(String applicantName, String email, String phoneNumber, String address, Status status, Course course) {
        this.applicantName = applicantName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.course = course;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantId=" + applicantId +
                ", applicantName='" + applicantName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return applicantId == applicant.applicantId && Objects.equals(applicantName, applicant.applicantName) && Objects.equals(email, applicant.email) && Objects.equals(phoneNumber, applicant.phoneNumber) && Objects.equals(address, applicant.address) && Objects.equals(status, applicant.status) && Objects.equals(course, applicant.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicantId, applicantName, email, phoneNumber, address, status, course);
    }
}
