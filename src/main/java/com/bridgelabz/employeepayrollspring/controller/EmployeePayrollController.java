package com.bridgelabz.employeepayrollspring.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employee, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			List<String> collect = bindingResult.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(collect, "validation error"), HttpStatus.BAD_REQUEST);
		}
		Employee emp = employeePayrollService.addEmployee(employee);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(emp, "Employee created successfully"), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getEmployee(@PathVariable("id") int employeeId){
		Employee employee = employeePayrollService.getEmployeeById(employeeId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employee, "Employee Fetched Successfully"), HttpStatus.OK);
	}
}

