package com.bridgelabz.employeepayrollspring.exception;

public class EmployeepayrollException extends RuntimeException{
	
	public final exceptionType type;
	
	public EmployeepayrollException(exceptionType type, String message) {
		super(message);
		this.type = type;
	}
	
	public enum exceptionType{
		EMPLOYEE_NOT_FOUND
	}
}
