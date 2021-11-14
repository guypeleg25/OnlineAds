package com.example.Guy.Controller;

import com.example.Guy.Exceptions.ExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ExistsException.class)
    public ResponseEntity<String> existsExceptionHandler(){
        return new ResponseEntity<>("There is an exists object " , HttpStatus.CONFLICT);
    }

}
