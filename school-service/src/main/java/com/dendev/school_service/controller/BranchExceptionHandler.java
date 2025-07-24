package com.dendev.school_service.controller;

import com.dendev.school_service.entity.BranchErrorResponse;
import com.dendev.school_service.exception.BranchException;
import com.dendev.school_service.exception.SchoolException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BranchExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BranchErrorResponse> schoolException(BranchException branchException){
        BranchErrorResponse branchErrorResponse = new BranchErrorResponse();

        branchErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        branchErrorResponse.setMessage(branchException.getMessage());
        branchErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(branchErrorResponse,HttpStatus.NOT_FOUND);
    }
}
