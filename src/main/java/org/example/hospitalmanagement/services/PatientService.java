package org.example.hospitalmanagement.services;

import org.example.hospitalmanagement.entity.*;
import org.example.hospitalmanagement.repository.PatientRepository;
import org.springframework.stereotype.*;
import java.util.*;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id){
        return patientRepository.findById(id).orElse(null);
    }

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

}
