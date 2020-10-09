package com.example.dailyappointmentservice.controller;


import com.example.dailyappointmentservice.model.Appointment;
import com.example.dailyappointmentservice.model.Availability;
import com.example.dailyappointmentservice.model.GenericResponse;
import com.example.dailyappointmentservice.model.Physician;
import com.example.dailyappointmentservice.repository.AppointmentRepository;
import com.example.dailyappointmentservice.repository.AvailablityRepository;
import com.example.dailyappointmentservice.repository.PhysicianRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repository;
    
    @Autowired
    private AvailablityRepository availRepository;
    
    @Autowired
    private PhysicianRepository	physicianRepository;
    
    
    @RequestMapping(value="/get-physician/{physicianId}")
    public ResponseEntity<Physician> getPhysician(@PathVariable String physicianId){
        Physician physician = physicianRepository.findByPhysicianId(physicianId);
        return new ResponseEntity<Physician>(physician, HttpStatus.OK);
    }
   
    @RequestMapping(value="/get-physicians/{speciality}")
    public ResponseEntity<List<Physician>> getPhysicians(@PathVariable String speciality) {
    	List<Physician> physiciansWithSpeciality = physicianRepository.findBySpeciality(speciality);
    	return new ResponseEntity<List<Physician>>(physiciansWithSpeciality, HttpStatus.OK);
    }
    
    
    @RequestMapping(value="/get-physicians-all")
    public ResponseEntity<List<Physician>> getAllPhysicians() {
    	List<Physician> physicians = physicianRepository.findAll();
    	return new ResponseEntity<List<Physician>>(physicians, HttpStatus.OK);

    }
    @RequestMapping(value="/get-slot/{availibiltyId}")
    public ResponseEntity<Availability> getAvailableSlots(@PathVariable String availibiltyId) {
    	Availability appointmentSlot = availRepository.findByAvailabilityId(availibiltyId);
    	return new ResponseEntity<Availability>(appointmentSlot, HttpStatus.OK);
    }
    
    
    @RequestMapping(value="/get-slots/{physicianId}/{date}")
    public ResponseEntity<List<Availability>> getAvailableSlots(@PathVariable String physicianId, @PathVariable Date date) {
    	List<Availability> allAvailSlots = availRepository.findByPhysicianIdAndDate(physicianId, date);
    	return new ResponseEntity<List<Availability>>(allAvailSlots, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/add-slot", method = RequestMethod.POST)
    public GenericResponse addAvailabilty(@RequestBody Availability availabilty){
        availRepository.save(availabilty);
        return new GenericResponse(1, "success", availabilty);
    }
    
    
    @RequestMapping(value = "/add-physician", method = RequestMethod.POST)
    public GenericResponse addPhysician(@RequestBody Physician physician){
        physicianRepository.save(physician);
        return new GenericResponse(1, "success", physician);
    }
    

    @RequestMapping(value = "/set-appointment/{availabilityId}", method = RequestMethod.POST)
    public GenericResponse setAppointment(@RequestBody Appointment appointment, @PathVariable String availabilityId){
    	availRepository.updateAvailability(availabilityId);
        repository.save(appointment);
        return new GenericResponse(1, "success", appointment);
    }

    @RequestMapping("/get-appointment-all")
    public GenericResponse getAllAppointment(){
        List<Appointment> allAppointment =  repository.findAll();
        return new GenericResponse(1, "success", allAppointment);
    }

    @RequestMapping("/get-appointment/{physicianId}")
    public GenericResponse getAppointmentByPhysician(@PathVariable String physicianId){
        List<Appointment> appointments = repository.findAllByPhysicianId(physicianId);
        return new GenericResponse(1, "success", appointments);
    }
}
