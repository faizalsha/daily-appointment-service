package com.example.dailyappointmentservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;


@Entity
public class Appointment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "appointment_id")
    private String appointmentId;
    @Column(name = "physician_id")
    private String physicianId;
    @Column(name = "patient_id")
    private String patientId;
    private Date date;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name= "end_time")
    private Time endTime;

    public Appointment() {
    }

    public Appointment(String appointmentId, String physicianId, String patientId, Date date, Time startTime, Time endTime) {
        this.appointmentId = appointmentId;
        this.physicianId = physicianId;
        this.patientId = patientId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointment_id) {
        this.appointmentId = appointment_id;
    }

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physician_id) {
        this.physicianId = physician_id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patient_id) {
        this.patientId = patient_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

    
}
