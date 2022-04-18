
public class MyException extends RuntimeException {

	public MyException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Your error is: " + super.getMessage();
	}
	
}
