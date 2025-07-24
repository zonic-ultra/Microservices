package com.dendev.school_service.service;

import com.dendev.school_service.dto.SchoolDto;
import com.dendev.school_service.entity.School;
import com.dendev.school_service.exception.SchoolException;
import com.dendev.school_service.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public SchoolDto addSchool(SchoolDto schoolDto) {
        School addSchool = schoolRepository.save(new School(schoolDto));

        return new SchoolDto(addSchool);
    }

    @Override
    public SchoolDto updateSchool(School school) {
        School updateSchool = schoolRepository.save(school);

        return new SchoolDto(updateSchool);
    }

    @Override
    public String deleteSchool(Long id) {
        schoolRepository.deleteById(id);
        return "School id "+ id + " has been deleted";
    }

    @Override
    public SchoolDto getSchoolById(Long id) {
        School existingSchool = schoolRepository.findById(id).orElseThrow(()-> new SchoolException("School id " +id+" not found!"));
        return new SchoolDto(existingSchool);
    }

    @Override
    public List<SchoolDto> getAllSchools() {
        List<SchoolDto> schoolDtoList = schoolRepository.findAll().stream().map(SchoolDto::new).collect(Collectors.toList());
        return schoolDtoList;
    }
}
