package com.example.dailyappointmentservice.repository;

import com.example.dailyappointmentservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
    List<Appointment> findAllByPhysicianId(String physicianId);
}
