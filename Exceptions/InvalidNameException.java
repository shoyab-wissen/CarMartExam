package Test.Exceptions;

public class InvalidNameException extends CarException {
    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException() {
        super();
    }
}
