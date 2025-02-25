package Test.Exceptions;

public class IdNotFoundException extends CarException {
    public IdNotFoundException(String message) {
        super(message);
    }

    public IdNotFoundException() {
        super();
    }
}