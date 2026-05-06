package org.example.hospitalmanagement.services;


import org.example.hospitalmanagement.entity.*;
import org.example.hospitalmanagement.repository.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorsRepository doctorsRepository;
    private final PatientRepository patientRepository;


    public AppointmentService(AppointmentRepository appointmentRepository, DoctorsRepository doctorsRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorsRepository = doctorsRepository;
        this.patientRepository = patientRepository;
    }

    public Appointment bookingAppointment(Long patientId, Long doctorId, Appointment appointment){
        Patient patient = patientRepository.findById(patientId).orElse(null);
        Doctor doctor = doctorsRepository.findById(doctorId).orElse(null);
        appointment.setAppointmentDate(appointment.getAppointmentDate());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStatus("Booked");

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }



}
