package org.example.hospitalmanagement.services;


import org.example.hospitalmanagement.entity.*;
import org.example.hospitalmanagement.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;
import org.springframework.web.server.ResponseStatusException;

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

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found"));

        Doctor doctor = doctorsRepository.findById(doctorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found"));

        appointment.setAppointmentDate(appointment.getAppointmentDate());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStatus("Booked");

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }




    public Appointment updateAppointment(Long id, Long patientId, Long doctorId, Appointment appointment) {
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));

        Doctor existingDoctor = doctorsRepository.findById(patientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));

        Patient existingPatient = patientRepository.findById(doctorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));

        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existingAppointment.setPatient(existingPatient);
        existingAppointment.setDoctor(existingDoctor);

        return appointmentRepository.save(existingAppointment);
    }

    public void deleteByAppointment(Long id){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
        appointmentRepository.delete(appointment);
    }

    public Appointment getAppointmentById(Long id){

        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
    }
}
