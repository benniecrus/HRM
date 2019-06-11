package iist.training.hrm.exception;

public class PositionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public PositionNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
