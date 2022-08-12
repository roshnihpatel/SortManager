package com.sparta.rp.exceptions;

public class ChildNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Child not found";
    }
}
