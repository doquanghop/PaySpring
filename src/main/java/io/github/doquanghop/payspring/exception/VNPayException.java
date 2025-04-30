package io.github.doquanghop.payspring.exception;

public class VNPayException extends RuntimeException {
    private final String code;

    public VNPayException(String code) {
        super();
        this.code = code;
    }

    public VNPayException(String code, String message) {
        super(message);
        this.code = code;
    }

    public VNPayException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
