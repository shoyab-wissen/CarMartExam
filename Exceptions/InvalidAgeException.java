package Test.Exceptions;

public class InvalidAgeException extends CarException {
    public InvalidAgeException(String message) {
        super(message);
    }

    public InvalidAgeException() {
        super();
    }
}