package be.intecbrussel;

public class CustomException extends Throwable {
    public CustomException() {
        super();
    }

    public CustomException(String stringMessage) {
        super(stringMessage);
    }
}
