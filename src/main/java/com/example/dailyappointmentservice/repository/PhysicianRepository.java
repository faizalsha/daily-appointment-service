package com.example.dailyappointmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailyappointmentservice.model.Physician;

public interface PhysicianRepository extends JpaRepository<Physician, String> {
	List<Physician> findBySpeciality(String speciality);
	Physician findByPhysicianId(String physicianId);
}
