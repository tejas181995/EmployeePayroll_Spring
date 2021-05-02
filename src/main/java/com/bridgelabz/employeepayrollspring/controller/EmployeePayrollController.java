package com.bridgelabz.employeepayrollspring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.bridgelabz.employeepayrollspring.DTO.UpdateEmployeeDTO;
import com.bridgelabz.employeepayrollspring.services.IEmployeePayrollServices;

/**
 * connection with server
 * @author Tejas Dev
 *
 */
@RestController
@RequestMapping("/employeePayroll")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollServices employeePayrollService;
	
	/**
	 * method add new employee
	 * @param employee
	 * @return employee details
	 */
	@PostMapping
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employee){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employeePayrollService.addEmployee(employee), "Employee created successfully"), HttpStatus.CREATED);
	}
	/**
	 * method to get list of employees
	 * @return list of employee 
	 */
	@GetMapping("/all")
	public ResponseEntity<ResponseDTO> getAllEmployee(){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employeePayrollService.getEmployees(), "Employees fetched successfully"), HttpStatus.OK);
	}
	/**
	 * method to find employee by id
	 * @param employeeId
	 * @return employee details
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getEmployee(@PathVariable("id") int employeeId){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employeePayrollService.getEmployeeById(employeeId), "Employee Fetched Successfully"), HttpStatus.OK);
	}
	/**
	 * method to update employee details
	 * @param employeeId
	 * @param employee
	 * @return employee details
	 */
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<ResponseDTO> updateEmp(@PathVariable("id") int employeeId, @Valid @RequestBody UpdateEmployeeDTO employee){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employeePayrollService.updateEmployee(employeeId, employee), "updated details successfullu"), HttpStatus.OK);
	}
	/**
	 * method to delete employee details from DB
	 * @param id
	 * @return employee details
	 */
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<ResponseDTO> deleteEmp(@PathVariable("id") int id) {
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employeePayrollService.deleteEmployee(id), "Employee Deleted successfully"), HttpStatus.OK);
	}
}

