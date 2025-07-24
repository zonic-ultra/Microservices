package com.dendev.school_service.service;

import com.dendev.school_service.entity.Student;
import com.dendev.school_service.exception.StudentException;
import com.dendev.school_service.repository.StudentRepository;
import com.dendev.school_service.studentDto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public StudentDto createStudent(StudentDto studentDto){
        Student student = studentRepository.save(new Student(studentDto));

        return new StudentDto(student);
    }

    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {
        Student existingStud = studentRepository.findById(studentId).orElseThrow(()-> new StudentException("Student Id " +studentId+ " is not found!"));
            if (existingStud != null){
                existingStud.setFirst_name(studentDto.getFirst_name());
                existingStud.setLast_name(studentDto.getLast_name());
                existingStud.setCourse(studentDto.getCourse());
                existingStud.setAge(studentDto.getAge());

                studentRepository.save(existingStud);
            }


            return new StudentDto(existingStud);
    }

    public StudentDto findStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new StudentException("Student Id " + studentId + " not found!"));

        return new StudentDto(student);
    }


    public String deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
        return "Student Id " + studentId + " has been deleted";
    }

    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentDtoList = studentRepository.findAll().stream().map(StudentDto::new).collect(Collectors.toList());
        return studentDtoList;
    }
}
