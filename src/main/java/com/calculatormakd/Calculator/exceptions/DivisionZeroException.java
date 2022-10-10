package com.calculatormakd.Calculator.exceptions;

public class DivisionZeroException extends IllegalArgumentException {
    public DivisionZeroException() {
    }

    public DivisionZeroException(String s) {
        super(s);
    }

    public DivisionZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public DivisionZeroException(Throwable cause) {
        super(cause);
    }
}
