package com.bridgelabz.employeepayrollspring.services;

import java.util.List;

import com.bridgelabz.employeepayrollspring.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.DTO.UpdateEmployeeDTO;
import com.bridgelabz.employeepayrollspring.model.Employee;


public interface IEmployeePayrollServices {
	
	public List<Employee> getEmployees();
	public Employee addEmployee(EmployeeDTO employee);
	public Employee getEmployeeById(int employeeId);
	public Employee updateEmployee(int employeeId, UpdateEmployeeDTO employee);
	public Employee deleteEmployee(int employeeId);
}
