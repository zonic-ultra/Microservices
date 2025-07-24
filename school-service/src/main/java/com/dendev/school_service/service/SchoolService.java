package com.dendev.school_service.service;

import com.dendev.school_service.dto.SchoolDto;
import com.dendev.school_service.entity.School;

import java.util.List;
import java.util.Optional;

public interface SchoolService {
    SchoolDto addSchool(SchoolDto schoolDto);
    SchoolDto updateSchool(School school);

    String deleteSchool(Long id);
    SchoolDto getSchoolById(Long id);
    List<SchoolDto> getAllSchools();

}
