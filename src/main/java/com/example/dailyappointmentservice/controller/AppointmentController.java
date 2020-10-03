package com.example.dailyappointmentservice.controller;


import com.example.dailyappointmentservice.model.Appointment;
import com.example.dailyappointmentservice.model.GenericResponse;
import com.example.dailyappointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repository;

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
}
