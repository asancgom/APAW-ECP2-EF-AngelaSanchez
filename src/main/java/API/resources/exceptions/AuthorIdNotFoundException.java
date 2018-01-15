package API.resources.exceptions;

public class AuthorIdNotFoundException extends Exception {

	private static final long serialVersionUID = -987888656456123777L;

	public static final String ERROR = "Id del autor no encontrado";

	public AuthorIdNotFoundException(String comment) {
		super(ERROR + ". " + comment);
	}

	public AuthorIdNotFoundException() {
		this("");
	}

}
