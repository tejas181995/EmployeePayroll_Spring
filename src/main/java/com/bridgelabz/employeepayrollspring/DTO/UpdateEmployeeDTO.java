package com.bridgelabz.employeepayrollspring.DTO;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UpdateEmployeeDTO {
	@Nullable
	@Size(min = 3, max = 15)
	private String name;

	@Nullable
	@Email(message = "please enter valid email")
	private String email;

	@Nullable
	@Pattern(regexp = "[0-9]{10}", message = "please enter valid phone")
	private String phone;
	
	@Nullable
	private String address;
	
	@Nullable
	@Min(value = 300000, message = "salary should be more than 3 lac.")
	private double salary=300000;
	
	@Nullable
	@JsonFormat(pattern = "yyyy/MM/dd")
    private Date startDate;
	
	private List<String> department;
}
