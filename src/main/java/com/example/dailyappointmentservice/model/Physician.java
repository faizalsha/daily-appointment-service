package com.example.dailyappointmentservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Physician {
	
	@Id
	@Column(name="physician_id")
	private int physicainId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String phone;
	private String email;
	private String speciality;
	
	Physician(){
		
	}

	public Physician(int physicainId, String firstName, String lastName, String phone, String email,
			String speciality) {
		super();
		this.physicainId = physicainId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.speciality = speciality;
	}

	public int getPhysicainId() {
		return physicainId;
	}

	public void setPhysicainId(int physicainId) {
		this.physicainId = physicainId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
