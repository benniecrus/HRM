package iist.training.hrm.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class NewEmployeeDto {
	@NotBlank
	@Pattern(regexp = "([a-zA-Z]+)")
	private String firstName;
	@NotBlank
	@Pattern(regexp = "([a-zA-Z\\s]+)")
	private String lastName;
	@NotBlank
	@Pattern(regexp = "([0-9]{10})")
	private String phoneNumber;
	@Min( value = 0)
	private double salary;
	@Pattern(regexp = "[0-1][0-9]\\/[0-3][0-9]\\/[1-2][0-9]{3}")
	private String dob;
	@NotBlank
	private String address;
	@NotBlank
	private String countryCode;

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

}
