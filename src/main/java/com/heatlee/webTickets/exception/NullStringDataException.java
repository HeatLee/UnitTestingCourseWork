package com.heatlee.webTickets.exception;

public class NullStringDataException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "Null data is not valid for validation.";
    public NullStringDataException() {
        super();
    }

    public NullStringDataException(String message) {
        super(message);
    }
}
