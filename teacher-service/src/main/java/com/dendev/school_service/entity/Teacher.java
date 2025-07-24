package com.dendev.school_service.entity;

import com.dendev.school_service.dto.TeacherDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String rank;

    public Teacher(TeacherDto teacherDto){
        this.id = teacherDto.getId();
        this.name = teacherDto.getName();
        this.rank = teacherDto.getRank();
    }
}
