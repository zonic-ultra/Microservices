package com.dendev.school_service.controller;

import com.dendev.school_service.entity.BranchErrorResponse;
import com.dendev.school_service.entity.SchoolErrorResponse;
import com.dendev.school_service.exception.SchoolException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SchoolExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<SchoolErrorResponse> schoolException(SchoolException schoolException){
        SchoolErrorResponse schoolErrorResponse = new SchoolErrorResponse();

        schoolErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        schoolErrorResponse.setMessage(schoolException.getMessage());
        schoolErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(schoolErrorResponse,HttpStatus.NOT_FOUND);
    }
}
