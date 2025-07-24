package com.dendev.school_service.studentDto;

import com.dendev.school_service.entity.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @NotBlank(message = "Student Id is required!")
    private Long studentId;

    private String first_name;
    private String last_name;
    private String course;
    private int age;

    public StudentDto(Student student){
        this.studentId = student.getStudentId();
        this.first_name = student.getFirst_name();
        this.last_name = student.getLast_name();
        this.course = student.getCourse();
        this.age = student.getAge();
    }
}
