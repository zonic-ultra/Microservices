package com.dendev.school_service.controller;

import com.dendev.school_service.dto.TeacherDto;
import com.dendev.school_service.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<?> getListOfTeachers(){
        List<TeacherDto> teacherDtoList = teacherService.getListOFTeachers();

        return new ResponseEntity<>(teacherDtoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Long id){
        TeacherDto findById = teacherService.getTeacherById(id);

        return new ResponseEntity<>(findById, HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDto teacherDto){
        TeacherDto addTeacher = teacherService.addTeacher(teacherDto);

        return new ResponseEntity<>(addTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable Long id, @RequestBody @Valid TeacherDto teacherDto){
        TeacherDto updateTeacher = teacherService.updateTeacher(id,teacherDto);

        return new ResponseEntity<>(updateTeacher, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTeacherById(@PathVariable Long id){
       return teacherService.deleteTeacherById(id);
    }

}
