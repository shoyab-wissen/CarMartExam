package Test.Exceptions;

public class IdAlreadyExistsException extends CarException {
    public IdAlreadyExistsException(String message) {
        super(message);
    }

    public IdAlreadyExistsException() {
        super();
    }
}