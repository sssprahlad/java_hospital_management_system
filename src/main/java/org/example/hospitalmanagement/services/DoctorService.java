package org.example.hospitalmanagement.services;

import org.example.hospitalmanagement.entity.*;
import org.example.hospitalmanagement.repository.DoctorsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class DoctorService {
    private final DoctorsRepository doctorsRepository;

    public DoctorService(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorsRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors(){
        return doctorsRepository.findAll();
    }

    public Doctor getDoctorById(Long id){
        return doctorsRepository.findById(id).orElse(null);
    }

    public void deleteDoctorById(Long id){
      Doctor doctor = doctorsRepository.findById(id)
              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Doctor not found"));
      doctorsRepository.delete(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor updateDoctor){
        Doctor existingDoctor = doctorsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found"));
        existingDoctor.setName(updateDoctor.getName());
        existingDoctor.setSpecialization(updateDoctor.getSpecialization());

        return doctorsRepository.save(existingDoctor);


    }



}
