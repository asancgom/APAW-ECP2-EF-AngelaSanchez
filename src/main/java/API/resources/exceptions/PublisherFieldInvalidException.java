package API.resources.exceptions;

public class PublisherFieldInvalidException extends Exception {
	
	    private static final long serialVersionUID = -987888656456123777L;

	    public static final String ERROR = "Campos incorrectos";

	    public PublisherFieldInvalidException(String field) {
	        super( ERROR + ": " + field);
	    }
	    
	    public PublisherFieldInvalidException(int id) {
	        super( ERROR + ": id, valor:" + id);
	    }

	    public PublisherFieldInvalidException() {
	        this("");
	    }
}
