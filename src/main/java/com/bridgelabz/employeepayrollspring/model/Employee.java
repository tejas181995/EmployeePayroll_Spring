package com.bridgelabz.employeepayrollspring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.bridgelabz.employeepayrollspring.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.DTO.UpdateEmployeeDTO;

import lombok.Data;

/**
 * 
 * @author Tejas Dev
 *
 */
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
	
	@ElementCollection
	@CollectionTable(name = "emp_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> department;
	
	public Employee() {}
	
	/**
	 * constructor for creating new employee details
	 * @param employee
	 */

	public Employee(EmployeeDTO employee) {
		this.name = employee.getName();
		this.email = employee.getEmail();
		this.phone = employee.getPhone();
		this.address = employee.getAddress();
		this.salary = employee.getSalary();
		this.startDate = employee.getStartDate();
		this.department = employee.getDepartment();	
	}

	/**
	 * method to update employee details
	 * @param employee
	 */
	public void updateEmployeeDetails(UpdateEmployeeDTO employee) {
		this.name = employee.getName() == null ? this.name : employee.getName() ;
		this.email = employee.getEmail() == null ? this.email : employee.getEmail();
		this.phone = employee.getPhone() == null ? this.phone : employee.getPhone();
		this.address = employee.getAddress() == null ? this.address : employee.getAddress();
		this.salary = employee.getSalary() == 300000 ? this.salary : employee.getSalary();
		this.startDate = employee.getStartDate() == null ? this.startDate : employee.getStartDate();
		this.department = employee.getDepartment() == null ? this.department : employee.getDepartment();
	}

}
