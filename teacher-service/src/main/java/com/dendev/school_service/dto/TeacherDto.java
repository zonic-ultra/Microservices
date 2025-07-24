package com.dendev.school_service.dto;

import com.dendev.school_service.entity.Teacher;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private Long id;

    @NotEmpty(message = "Name is required!")
    private String name;

    @NotBlank(message = "Rank is required")
    private String rank;

    public TeacherDto(Teacher teacher){
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.rank = teacher.getRank();
    }
}
