package API.resources.exceptions;

public class PublisherIdNotFoundException extends Exception {

	private static final long serialVersionUID = -987888656456123777L;

	public static final String ERROR = "Id de la publicación no encontrado";

	public PublisherIdNotFoundException(String comment) {
		super(ERROR + ". " + comment);
	}

	public PublisherIdNotFoundException() {
		this("");
	}

}
