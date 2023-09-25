package com.qsp.springbootemployee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Entity     
//@Data
//@Getter
//@Setter
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name Can't Be Blank")
	@NotNull(message = "Name Can't Be  Null")
	private String name;
	@Column(unique = true)
	//@Pattern(regexp = "[6-9][0-9]{9}") if phone number is String regexp can't be use for number data type
	//@NotNull(message = "Phone Can't Be  Null")
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	@NotBlank(message = "Address Can't Be Blank")
	@NotNull(message = "Address Can't Be  Null")
	private String address;
	@Column(unique = true)
	@NotBlank(message = "Email Can't Be Blank")
	@NotNull(message = "Email Can't Be  Null")
	@Email(regexp = ".+@.+\\..+", message = "Invalid email format")
	private String email;
	@Min(value = 1)
	private double salary;
	private char grade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", email="
				+ email + ", salary=" + salary + ", grade=" + grade + "]";
	}
	
	
	
	

}
