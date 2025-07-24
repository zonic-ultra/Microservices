package com.dendev.school_service.entity;

import com.dendev.school_service.studentDto.StudentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    private Long studentId;

    private String first_name;
    private String last_name;
    private String course;
    private int age;

    public Student(StudentDto studentDto){
        this.studentId = studentDto.getStudentId();
        this.first_name = studentDto.getFirst_name();
        this.last_name = studentDto.getLast_name();
        this.course = studentDto.getCourse();
        this.age = studentDto.getAge();
    }
}
