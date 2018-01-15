package API.resources.exceptions;

public class RequestInvalidException extends Exception {
    private static final long serialVersionUID = -987888656456123777L;

    public static final String ERROR = "Petición no permitida";

    public RequestInvalidException(String comment) {
        super(ERROR + ". " + comment);
    }

    public RequestInvalidException() {
        this("");
    }
}
