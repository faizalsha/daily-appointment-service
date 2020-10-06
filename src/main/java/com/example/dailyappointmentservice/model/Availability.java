package com.example.dailyappointmentservice.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Availability {
	
	@Id
	@Column(name="availability_id")
	private int Id;
	@Column(name = "physician_id")
	private String physicianId;
	private Date date;
	@Column(name = "start_time")
	private Time startTime;
	@Column(name = "end_time")
	private Time endTime;
	@Column(name="booking_status")
	private boolean bookingStatus;
	
	
	public Availability(){
		
	}


	public Availability(String physicianId, Date date, Time startTime, Time endTime, boolean bookingStatus) {
		super();
		this.physicianId = physicianId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.bookingStatus = bookingStatus;
	}


	public String getPhysicianId() {
		return physicianId;
	}


	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
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


	public boolean isBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	
}
