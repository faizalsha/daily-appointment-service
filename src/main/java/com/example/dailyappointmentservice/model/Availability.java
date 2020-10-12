package com.example.dailyappointmentservice.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "availability")
public class Availability {
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="availability_id")
	private String availabilityId;
	@Column(name = "physician_id")
	private String physicianId;
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date date;
	
	@JsonFormat(pattern = "HH:mm")
	@JsonDeserialize(using = SqlTimeDeserializer.class)
	@Column(name = "start_time")
	private Time startTime;
	
	@JsonFormat(pattern = "HH:mm")
	@JsonDeserialize(using = SqlTimeDeserializer.class)
	@Column(name = "end_time")
	private Time endTime;
	@Column(name="booking_status")
	private boolean bookingStatus;
	
	
	public Availability(){
		
	}


	public Availability(String availabilityId,String physicianId, Date date, Time startTime, Time endTime, boolean bookingStatus) {
		super();
		this.availabilityId = availabilityId;
		this.physicianId = physicianId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.bookingStatus = bookingStatus;
	}


	public String getAvailabilityId() {
		return availabilityId;
	}


	public void setAvailabilityId(String availabilityId) {
		this.availabilityId = availabilityId;
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
