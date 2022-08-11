package com.sparta.rp.exceptions;

public class SorterLoaderException extends RuntimeException {
    private final String message;

    public SorterLoaderException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
