package org.example.hospitalmanagement.repository;

import org.example.hospitalmanagement.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
