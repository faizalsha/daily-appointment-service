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
import java.sql.Time;
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
    
    @RequestMapping(value="/get-slots/{physicianId}/{date}")
    public ResponseEntity<List<Availability>> getAvailableSlots(@PathVariable String physicianId, @PathVariable Date date) {
    	List<Availability> allAvailSlots = availRepository.findByPhysicianIdAndDate(physicianId, date);
    	return new ResponseEntity<List<Availability>>(allAvailSlots, HttpStatus.OK);
    }

    @RequestMapping(value = "/set-appointment", method = RequestMethod.POST)
    public GenericResponse setAppointment(@RequestBody Appointment appointment){
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

    @RequestMapping("/delete-appointment/{appointmentId}")
    public GenericResponse deleteAppointmentById(@PathVariable String appointmentId){
        try{
            repository.deleteById(appointmentId);
            return new GenericResponse(1, "success", null);
        }catch (Exception e){
            return new GenericResponse(0, "exception Occurred", null);
        }
    }

    @RequestMapping("delete-availability/{availabilityId}")
    public GenericResponse deleteAvailabilityById(@PathVariable String availabilityId){
        try{
            availRepository.deleteById(availabilityId);
            return new GenericResponse(1, "success", null);
        }catch (Exception e){
            e.printStackTrace();
            return new GenericResponse(0,"exception occurred", null);
        }
    }

    //sample
    @RequestMapping("/sample")
    public GenericResponse getSample(){
        Appointment appointment = new Appointment();
        appointment.setAppointmentId("abc");
        appointment.setDate(new Date(10, 10, 10));
        appointment.setTime(new Time(10, 10, 10));
        appointment.setPatientId("patient ID");
        appointment.setPhysicianId("physician ID");
        return new GenericResponse(1, "success", appointment);
    }
}
