package com.mindhub.todolist.exceptions;

public class NotFoundTaskException extends RuntimeException {

    public NotFoundTaskException(String message) {
        super(message);
    }
}
