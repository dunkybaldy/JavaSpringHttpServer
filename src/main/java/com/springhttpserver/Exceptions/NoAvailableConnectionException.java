package com.springhttpserver.Exceptions;

public class NoAvailableConnectionException extends Exception {
    public NoAvailableConnectionException(String errorMessage) {
        super(errorMessage);
    }
}
