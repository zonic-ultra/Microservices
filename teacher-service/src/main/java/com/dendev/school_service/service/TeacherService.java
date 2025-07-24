package com.dendev.school_service.service;

import com.dendev.school_service.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
  TeacherDto addTeacher(TeacherDto teacherDto);
  TeacherDto updateTeacher(Long id, TeacherDto teacherDto);
  String deleteTeacherById(Long id);
  TeacherDto getTeacherById(Long id);
  List<TeacherDto> getListOFTeachers();

}
