package com.dendev.school_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherErrorResponse {
    private Integer status;
    private String message;
    private Long timeStamp;
}
