package org.example.hospitalmanagement.controller;

import org.example.hospitalmanagement.entity.*;
import org.example.hospitalmanagement.services.DoctorService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteByDoctorId(@PathVariable Long id){
        doctorService.deleteDoctorById(id);
        return "Doctor has been deleted.";
    }

    @PatchMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor){
        return doctorService.updateDoctor(id, doctor);

    }




}
