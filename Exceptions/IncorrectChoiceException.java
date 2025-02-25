package Test.Exceptions;

public class IncorrectChoiceException extends CarException {
    public IncorrectChoiceException(String message) {
        super(message);
    }

    public IncorrectChoiceException() {
        super();
    }
}