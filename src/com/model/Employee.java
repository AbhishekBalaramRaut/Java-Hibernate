package com.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	private String employeeName;

	private Address address;
	
	@AttributeOverrides({
		@AttributeOverride(name="state",column=@Column(name="OFFICE_STATE")),
		@AttributeOverride(name="city",column=@Column(name="OFFICE_CITY")),
		@AttributeOverride(name="street",column=@Column(name="OFFICE_STREET")),
	})
	private Address officeAddress;
	
	private Date joiningDate;
	
	/*Annotation :
		@Transient  if you don't want this particular to be part of database table column 
		@Temporal(TemporalType.DATE) if you dont want whole date to be saved with timestamp.
*/	
	
	public Employee(String employeeName) {
		this.employeeName = employeeName;
		this.joiningDate = new Date();
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
}
