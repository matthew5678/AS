package com.example.AS.controller;

import com.example.AS.error.SignupValidationExMessage;
import com.example.AS.error.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandleExceptionController {


    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<SignupValidationExMessage> handleValidationException(
            ValidationException validationException, WebRequest webRequest)
    {
        SignupValidationExMessage cvem = new SignupValidationExMessage();
        cvem.setStatus(HttpStatus.BAD_REQUEST.value());
        cvem.setLocalDateTime(LocalDateTime.now());
        cvem.setPath("/api/auth/signup");


        cvem.setError("Bad Request");
//        cvem.setError(validationException.getCause().toString());

        return new ResponseEntity<>(cvem, HttpStatus.BAD_REQUEST);
    }
}
