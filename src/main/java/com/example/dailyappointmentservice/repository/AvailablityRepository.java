package com.example.dailyappointmentservice.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailyappointmentservice.model.Availability;

public interface AvailablityRepository extends JpaRepository<Availability, String>{
	List<Availability> findByPhysicianIdAndDate(String physicianId, Date date);
	Availability findByAvailabilityId(String availabilityId); 
}
