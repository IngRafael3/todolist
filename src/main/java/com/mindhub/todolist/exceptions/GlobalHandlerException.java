package com.mindhub.todolist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<String> handlerResourceNotFoundException(NotFoundUserException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundTaskException.class)
    public ResponseEntity<String> handlerResourceNotFoundException(NotFoundTaskException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
