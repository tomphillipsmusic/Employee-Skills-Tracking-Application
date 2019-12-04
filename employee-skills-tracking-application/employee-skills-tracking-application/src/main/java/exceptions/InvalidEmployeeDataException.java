package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidEmployeeDataException extends RuntimeException{
	
	private static final long serialVersionUID = 6974644855556556892L;
	
	
	public InvalidEmployeeDataException(String message) {
		super(message);

	}


}