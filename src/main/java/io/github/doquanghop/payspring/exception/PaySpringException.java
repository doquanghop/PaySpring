package io.github.doquanghop.payspring.exception;

public class PaySpringException extends RuntimeException {
    private final String code;
    private final String message;

    public PaySpringException(String code) {
        super();
        this.code = code;
        this.message = null;
    }

    public PaySpringException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public PaySpringException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
