package com.dendev.school_service.service;

import com.dendev.school_service.studentDto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto updateStudent(Long studentId, StudentDto studentDto);
    String deleteStudentById(Long studentId);

    StudentDto findStudentById(Long studentId);

    List<StudentDto> getAllStudents();
}
