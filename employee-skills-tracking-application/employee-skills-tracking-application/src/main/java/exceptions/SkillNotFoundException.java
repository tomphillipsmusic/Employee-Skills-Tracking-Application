package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SkillNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6974644855556556895L;

	public SkillNotFoundException( String message) {
		super(message);

	}

}
