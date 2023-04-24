package model.exceptions;

import io.exceptions.IncorrectDataException;

public class GenreNotExistsException extends IncorrectDataException {

    public GenreNotExistsException(String message) {
        super(message);
    }
}
