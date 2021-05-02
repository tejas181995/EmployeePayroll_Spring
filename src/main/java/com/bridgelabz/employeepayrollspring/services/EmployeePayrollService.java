package com.bridgelabz.employeepayrollspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollspring.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.DTO.UpdateEmployeeDTO;
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
                                "Employee does not exist")
                );
    }

	

	@Override
	public Employee deleteEmployee(int employeeId) {
		Employee deletedEmployee = getEmployeeById(employeeId);
		employeePayrollRepo.deleteById(employeeId);
		return deletedEmployee;
		
	}

	@Override
	public Employee updateEmployee(int employeeId, UpdateEmployeeDTO employee) {
		Employee currEmp = getEmployeeById(employeeId);
		currEmp.updateEmployeeDetails(employee);
		return this.employeePayrollRepo.save(currEmp);
	}
	
}
