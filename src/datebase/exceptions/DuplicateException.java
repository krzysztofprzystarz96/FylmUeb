package datebase.exceptions;

import com.sun.jdi.request.DuplicateRequestException;

public class DuplicateException extends DuplicateRequestException {
    public DuplicateException(String message) {
        super(message);
    }
}
