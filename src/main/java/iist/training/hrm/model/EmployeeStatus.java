package iist.training.hrm.model;

public enum EmployeeStatus {
	WORKING(1, "WORKING"), LEAVE(2, "LEAVE");

	private int statusCode;
	private String statusName;

	private EmployeeStatus(int statusCode, String statusName) {
		this.statusCode = statusCode;
		this.statusName = statusName;
	}
	
	public static EmployeeStatus getEmployeeStatusByStatusCode(int statusCode) {
		for(EmployeeStatus employeeStatus : values()) {
			if(employeeStatus.statusCode == statusCode) {
				return employeeStatus;
			}
		}
		
		return null;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}
