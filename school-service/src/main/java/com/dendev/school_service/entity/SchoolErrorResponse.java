package com.dendev.school_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolErrorResponse {
    private Integer status;
    private String message;
    private Long timeStamp;
}
