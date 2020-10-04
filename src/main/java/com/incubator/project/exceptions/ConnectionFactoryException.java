package com.incubator.project.exceptions;

public class ConnectionFactoryException extends RuntimeException {
    public ConnectionFactoryException(Throwable cause) {
        super(cause);
    }

    public ConnectionFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionFactoryException(String message) {
        super(message);
    }

    public ConnectionFactoryException() {
    }
}
