package org.cap.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class PassRequestForm {
	private Integer requestId;
	private String employeeid;
	private String firstname;
	private String lastname;
	private String gender;
	private String address;
	private String email;
	private LocalDate doj;
	private String location;
	private String pickUpLoc;
	private LocalTime pickUpTime;
	private String Designation;
	private String status="pending";
	
	
	public PassRequestForm(Integer requestId, String employeeid, String firstname, String lastname, String gender,
			String address, String email, LocalDate doj, String location, String pickUpLoc, LocalTime pickUpTime,
			String designation, String status) {
		super();
		this.requestId = requestId;
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.doj = doj;
		this.location = location;
		this.pickUpLoc = pickUpLoc;
		this.pickUpTime = pickUpTime;
		Designation = designation;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public PassRequestForm() {
		super();
	}

	

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPickUpLoc() {
		return pickUpLoc;
	}

	public void setPickUpLoc(String pickUpLoc) {
		this.pickUpLoc = pickUpLoc;
	}

	public LocalTime getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(LocalTime pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	@Override
	public String toString() {
		return "PassRequestForm [requestId=" + requestId + ", employeeid=" + employeeid + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", gender=" + gender + ", address=" + address + ", email=" + email
				+ ", doj=" + doj + ", location=" + location + ", pickUpLoc=" + pickUpLoc + ", pickUpTime=" + pickUpTime
				+ "]";
	}
	
	
	
	
	
}