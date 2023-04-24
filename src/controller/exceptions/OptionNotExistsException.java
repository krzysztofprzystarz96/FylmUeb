package controller.exceptions;

public class OptionNotExistsException extends IllegalArgumentException {
    public OptionNotExistsException(String message) {
        super(message);
    }
}
