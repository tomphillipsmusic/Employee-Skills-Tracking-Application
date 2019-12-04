package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SkillNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 6974644855556556895L;

	private int id;

	public SkillNotFoundException(int id, String message) {
		super(message);
		setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
