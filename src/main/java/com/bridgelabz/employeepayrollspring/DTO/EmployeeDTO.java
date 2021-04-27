package com.bridgelabz.employeepayrollspring.DTO;

import javax.validation.constraints.*;

public class EmployeeDTO {
	
	@NotEmpty(message = "please enter name")
	@Size(min = 3, max = 15)
	private String name;

	@Email(message = "please enter valid email")
	private String email;

	@Pattern(regexp = "[0-9]{10}", message = "please enter valid phone")
	private String phone;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
