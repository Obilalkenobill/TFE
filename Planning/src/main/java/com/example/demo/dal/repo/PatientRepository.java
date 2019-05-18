package com.example.demo.dal.repo;

import org.springframework.stereotype.Repository;
import com.example.demo.dal.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
