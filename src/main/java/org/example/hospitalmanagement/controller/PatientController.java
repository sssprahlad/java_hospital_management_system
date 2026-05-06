package org.example.hospitalmanagement.controller;


import org.example.hospitalmanagement.entity.*;
import org.example.hospitalmanagement.services.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        System.out.println(patient.getAge() + " " + patient.getName() + " " + patient.getReason());
       return patientService.addPatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePatientById(@PathVariable Long id){
        patientService.deletePatientById(id);
        return "Patient has been deleted";
    }


}
