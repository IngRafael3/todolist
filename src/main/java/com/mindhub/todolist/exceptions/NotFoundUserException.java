package com.mindhub.todolist.exceptions;

public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(String message) {
        super(message);
    }
}
