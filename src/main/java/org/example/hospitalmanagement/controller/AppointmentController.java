package org.example.hospitalmanagement.controller;

import org.example.hospitalmanagement.entity.*;
import org.example.hospitalmanagement.services.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book")
    public Appointment bookingAppoint(
            @RequestParam Long patientId,
            @RequestParam Long doctorId,
            @RequestBody Appointment appointment){
        return appointmentService.bookingAppointment(patientId, doctorId, appointment);
    }

    @GetMapping("/book")
    public List<Appointment> getAllAppointments(){
        return  appointmentService.getAllAppointments();
    }

    @GetMapping("/book/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }


    @PatchMapping("/book/{id}")
    public Appointment updateAppointment(
            @PathVariable Long id,
            @RequestParam Long patientId,
            @RequestParam Long doctorId,
            @RequestBody Appointment appointment
    ){
        return appointmentService.updateAppointment(id, patientId,doctorId, appointment);
    }

    @DeleteMapping("/book/{id}")
    public String deleteByAppointment(@PathVariable Long id){
        appointmentService.deleteByAppointment(id);

        return "Appointment deleted Successfully.";

    }


}
