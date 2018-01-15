package API.resources.exceptions;

public class AuthorFieldInvalidException extends Exception {
	
	private static final long serialVersionUID = -987888656456123777L;

	public static final String ERROR = "Campos incorrectos";

	public AuthorFieldInvalidException(String field) {
		        super( ERROR + ": " + field);
		    }

	public AuthorFieldInvalidException(long id) {
		        super( ERROR + ": id, valor:" + id);
		 }

	public AuthorFieldInvalidException() {
		        this("");
		    }
}
