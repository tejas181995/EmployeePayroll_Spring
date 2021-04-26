package com.bridgelabz.employeepayrollspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollspring.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollspring.model.Employee;
import com.bridgelabz.employeepayrollspring.services.IEmployeePayrollServices;

@RestController
@RequestMapping("/employeePayroll")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollServices employeePayrollService;
	
	@PostMapping
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeeDTO employee){
		Employee emp = employeePayrollService.addEmployee(employee);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(emp, "Employee created successfully"), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseDTO> getEmployees(){
		List<Employee> employees = employeePayrollService.getEmployees();
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employees, "Employee Fetched Successfully"), HttpStatus.OK);
	}
}
