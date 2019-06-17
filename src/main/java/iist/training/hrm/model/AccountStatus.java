package iist.training.hrm.model;

public enum AccountStatus {
	INACTIVE(0, "INACTIVE"), ACTIVE(1, "ACTIVE"), BLOCKED(2, "BLOCKED");

	private int statusCode;
	private String statusName;

	private AccountStatus(int statusCode, String statusName) {
		this.statusCode = statusCode;
		this.statusName = statusName;
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
