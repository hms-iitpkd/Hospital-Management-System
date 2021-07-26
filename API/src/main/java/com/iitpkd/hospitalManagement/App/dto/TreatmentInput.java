package com.iitpkd.hospitalManagement.App.dto;

import java.util.Set;

public class TreatmentInput {

    private Treatment treatment;
    private Integer patientId;
    private Integer doctorId;
    private Set<Integer> medicineId;
    private Set<Integer> testId;

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Set<Integer> getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Set<Integer> medicineId) {
        this.medicineId = medicineId;
    }

    public Set<Integer> getTestId() {
        return testId;
    }

    public void setTestId(Set<Integer> testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "TreatmentInput{" +
                "treatment=" + treatment +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", medicineId=" + medicineId +
                ", testId=" + testId +
                '}';
    }
}
