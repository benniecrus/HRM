package com.iist.hrm.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class NewEmployeeDto {
	private int employeeId;
	@NotBlank(message = "First name must be not blank!")
	private String firstName;
	@NotBlank(message = "Last name must be not blank!")
	private String lastName;
	@NotBlank(message = "Email must be not blank!")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Email is invalid!")
	private String email;
	@NotBlank(message = "Phone number must be not blank!")
	@Pattern(regexp = "([0-9]{10})", message = "Phone number must be 10 number.")
	private String phoneNumber;
	@Min(value = 0, message = "Salary must be positive.")
	private double salary;
	@NotBlank(message = "DOB must be not blank!")
	@Pattern(regexp = "[0-1][0-9]\\/[0-3][0-9]\\/[1-2][0-9]{3}", message = "DOB must have format dd/MM/yyyy")
	private String dob;
	@NotBlank(message = "Address must be not blank!")
	private String address;
	@NotBlank(message = "Country must be not blank!")
	private String countryCode;
	private int positionId;
	@NotBlank(message = "Identity card number must be not blank!")
	@Pattern(regexp = "([0-9]+)", message = "Identity card number must be number.")
	private String idCardNo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
