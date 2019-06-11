package iist.training.hrm.exception;

public class ProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	
	public ProductException(String message) {
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
