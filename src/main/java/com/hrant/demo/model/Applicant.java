package com.hrant.demo.model;

import java.util.Objects;

public class Applicant {

    private int applicantId;

    private String applicantName;

    private String email;

    private String phoneNumber;

    private String address;

    private String status;

    public Applicant() {
    }

    public Applicant(String applicantName, String email, String phoneNumber, String address, String status) {
        this.applicantName = applicantName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return applicantId == applicant.applicantId && Objects.equals(applicantName, applicant.applicantName) && Objects.equals(email, applicant.email) && Objects.equals(phoneNumber, applicant.phoneNumber) && Objects.equals(address, applicant.address) && Objects.equals(status, applicant.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicantId, applicantName, email, phoneNumber, address, status);
    }
}
