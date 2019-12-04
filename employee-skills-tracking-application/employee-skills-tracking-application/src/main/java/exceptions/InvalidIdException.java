package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidIdException extends RuntimeException{
	
	private static final long serialVersionUID = 6974644855556556801L;


	public InvalidIdException(String message) {
		super(message);
	}

}