package com.bridgelabz.employeepayrollspring.DTO;

import java.util.Date;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeeDTO {
	
	@NotEmpty(message = "please enter name")
	@Size(min = 3, max = 15)
	private String name;

	@Email(message = "please enter valid email")
	private String email;

	@Pattern(regexp = "[0-9]{10}", message = "please enter valid phone")
	private String phone;
	
	@NotEmpty(message = "please enter address")
	private String address;
	
	@NotNull
	@Min(value = 300000, message = "salary should be more than 3 lac.")
	private double salary;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
    private Date startDate;
	
}
