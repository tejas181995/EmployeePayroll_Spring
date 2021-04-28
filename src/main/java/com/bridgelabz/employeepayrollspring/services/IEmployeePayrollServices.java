package com.bridgelabz.employeepayrollspring.services;

import java.util.List;

import com.bridgelabz.employeepayrollspring.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.model.Employee;


public interface IEmployeePayrollServices {
	
	public List<Employee> getEmployees();
	public Employee addEmployee(EmployeeDTO employee);
	public Employee getEmployeeById(int employeeId);
	public Employee updateEmployee(int employeeId, EmployeeDTO employee);
	public void deleteEmployee(int employeeId);
}
