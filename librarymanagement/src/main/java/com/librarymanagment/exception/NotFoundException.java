package com.librarymanagment.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String s) {
        throw new RuntimeException(s);
    }
}
