package com.bridgelabz.employeepayrollspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollspring.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.exception.EmployeepayrollException;
import com.bridgelabz.employeepayrollspring.model.Employee;
import com.bridgelabz.employeepayrollspring.repositary.IEmployeePayrollRepo;

@Service
public class EmployeePayrollService implements IEmployeePayrollServices {

	@Autowired
	private IEmployeePayrollRepo employeePayrollRepo;

	@Override
	public List<Employee> getEmployees() {
		return employeePayrollRepo.findAll();
	}

	@Override
	public Employee addEmployee(EmployeeDTO employee) {
		Employee newEmp = new Employee(employee);
		return this.employeePayrollRepo.save(newEmp);
	}

    @Override
    public Employee getEmployeeById(int employeeId) {
        return this.employeePayrollRepo.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeepayrollException(
                                EmployeepayrollException.exceptionType.EMPLOYEE_NOT_FOUND,
                                "Employee is not exist")
                );
    }

	@Override
	public Employee updateEmployee(int employeeId, EmployeeDTO employee) {
		Employee newEmployee = new Employee(employeeId, employee);
		return this.employeePayrollRepo.save(newEmployee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeePayrollRepo.deleteById(employeeId);
		
	}
	
}
