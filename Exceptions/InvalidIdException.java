package Test.Exceptions;

public class InvalidIdException extends CarException {
    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException() {
        super();
    }
}