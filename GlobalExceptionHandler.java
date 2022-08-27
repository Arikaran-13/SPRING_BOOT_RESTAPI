package com.arikaran.exception;

import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?>handleResourceNotfoundException(ResourceNotFoundException exception, WebRequest wr){
        ErrorDetails ed = new ErrorDetails(new Date(), exception.getMessage(),wr.getDescription(false));
        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<?>handleAnyException(Exception e, WebRequest wr){

        ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(),wr.getDescription(false));

        return new ResponseEntity<>(ed,HttpStatus.BAD_GATEWAY);

    }

}
