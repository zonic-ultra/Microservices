package com.dendev.school_service.controller;

import com.dendev.school_service.entity.TeacherErrorResponse;
import com.dendev.school_service.execption.TeacherException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TeacherExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<TeacherErrorResponse> teacherException(TeacherException teacherException){
        TeacherErrorResponse teacherErrorResponse = new TeacherErrorResponse();
        teacherErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        teacherErrorResponse.setMessage(teacherException.getMessage());
        teacherErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(teacherErrorResponse, HttpStatus.NOT_FOUND);
    }
}
