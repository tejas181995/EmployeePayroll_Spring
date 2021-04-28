package com.bridgelabz.employeepayrollspring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgelabz.employeepayrollspring.DTO.EmployeeDTO;

import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String email;
	private String phone;
	private String address;
	private double salary;
	private Date startDate;
	
	public Employee() {}
	
	

	public Employee(EmployeeDTO employee) {
		
		this.name = employee.getName();
		this.email = employee.getEmail();
		this.phone = employee.getPhone();
		this.address = employee.getAddress();
		this.salary = employee.getSalary();
		this.startDate = employee.getStartDate();
		
	}

	public Employee(int id , EmployeeDTO employee) {
		this.id = id;
		this.name = employee.getName();
		this.email = employee.getEmail();
		this.phone = employee.getPhone();
		this.address = employee.getAddress();
		this.salary = employee.getSalary();
		this.startDate = employee.getStartDate();
	}


	@Override
	public String toString() {
		return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                "}";
	}
}
