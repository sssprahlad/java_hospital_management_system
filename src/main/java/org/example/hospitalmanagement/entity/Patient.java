package org.example.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String reason;

    public Patient(){}

    public Patient(Long id, String name, int age, String reason) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.reason = reason;
    }

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;


}
