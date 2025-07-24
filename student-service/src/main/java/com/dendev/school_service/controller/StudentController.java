package com.dendev.school_service.controller;

import com.dendev.school_service.entity.Student;
import com.dendev.school_service.service.StudentServiceImpl;
import com.dendev.school_service.studentDto.StudentDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto addStud = studentService.createStudent(studentDto);
        return new ResponseEntity<>(addStud, HttpStatus.CREATED);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long studentId, @RequestBody StudentDto studentDto){
       StudentDto updateStudentById = studentService.updateStudent(studentId, studentDto);

       return new ResponseEntity<>(updateStudentById,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{studentId}")
    public String deleteStudentById(@PathVariable Long studentId){
        return studentService.deleteStudentById(studentId);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable Long studentId){
        StudentDto findByStudId = studentService.findStudentById(studentId);
        return new ResponseEntity<>(findByStudId,HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudent(){
        List<StudentDto> studentDtoList = studentService.getAllStudents();

        return new ResponseEntity<>(studentDtoList,HttpStatus.OK);
    }


}
