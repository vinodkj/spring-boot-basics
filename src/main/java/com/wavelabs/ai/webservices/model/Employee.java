package com.wavelabs.ai.webservices.model;

import javax.validation.constraints.Size;

public class Employee {
	private long id;
	
	public Employee() {
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", gender="
				+ gender + "]";
	}
	@Size(min = 2,max = 32,message = "Name Should be minimum 2 character and not greater then 32 character")
	private String name;
	private String email;
	private String address;
	private String gender;
	
	public Employee(long id, String name, String email, String address, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.gender = gender;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
