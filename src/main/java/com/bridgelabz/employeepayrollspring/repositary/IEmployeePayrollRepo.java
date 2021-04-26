package com.bridgelabz.employeepayrollspring.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employeepayrollspring.model.Employee;


@Repository
public interface IEmployeePayrollRepo extends JpaRepository<Employee, Integer>{

}