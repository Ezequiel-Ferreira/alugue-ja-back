package com.teste.ezequiel.alugueja.controllers.handlers;

import com.teste.ezequiel.alugueja.controllers.handlers.exceptions.StandardError;
import com.teste.ezequiel.alugueja.exceptions.AlreadyExistsException;
import com.teste.ezequiel.alugueja.exceptions.InsufficientFunds;
import com.teste.ezequiel.alugueja.exceptions.NotFoundException;
import com.teste.ezequiel.alugueja.exceptions.filme.FilmeTimeOverException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<StandardError> handlerAlreadyExists(AlreadyExistsException e){
        return new ResponseEntity<>(new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> handlerNotFound(NotFoundException e){
        return new ResponseEntity<>(new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(),
                System.currentTimeMillis()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientFunds.class)
    public ResponseEntity<StandardError> handlerInsufficientFunds(InsufficientFunds e){
        return new ResponseEntity<>(new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FilmeTimeOverException.class)
    public ResponseEntity<StandardError> handlerFilmeTimeOverException(FilmeTimeOverException e){
        return new ResponseEntity<>(new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }
}
