package com.bridgelabz.employeepayrollspring.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employee){
		Employee emp = employeePayrollService.addEmployee(employee);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(emp, "Employee created successfully"), HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<ResponseDTO> getAllEmployee(){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employeePayrollService.getEmployees(), "Employees fetched successfully"), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getEmployee(@PathVariable("id") int employeeId){
		Employee employee = employeePayrollService.getEmployeeById(employeeId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employee, "Employee Fetched Successfully"), HttpStatus.OK);
	}
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<ResponseDTO> updateEmp(@PathVariable("id") int employeeId, @Valid @RequestBody EmployeeDTO employee){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employeePayrollService.updateEmployee(employeeId, employee), "updated details successfullu"), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmp(@PathVariable("id") int id) {
		employeePayrollService.deleteEmployee(id);
	}
}

