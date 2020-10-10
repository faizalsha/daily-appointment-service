package com.example.dailyappointmentservice.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.dailyappointmentservice.model.Availability;


public interface AvailablityRepository extends JpaRepository<Availability, String>{
	
//	@Query("SELECT avail FROM Availabilty avail where avail.physicianId = ?0 AND avail.date = ?1 AND avail.bookingStatus=false")
	@Query(value = "SELECT * FROM availability a WHERE a.physician_id = ?1 AND a.date = ?2 AND a.booking_status=0 ORDER BY start_time ASC", nativeQuery = true)
	List<Availability> findByPhysicianIdAndDate(String physicianId, Date date);
	
	Availability findByAvailabilityId(String availabilityId); 
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="UPDATE availability a SET a.booking_status = b'1' WHERE a.availability_id = ?1", nativeQuery = true)
	void updateAvailability(String availibiltyId);
}
