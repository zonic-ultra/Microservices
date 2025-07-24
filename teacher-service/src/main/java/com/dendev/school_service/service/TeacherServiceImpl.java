package com.dendev.school_service.service;

import com.dendev.school_service.dto.TeacherDto;
import com.dendev.school_service.entity.Teacher;
import com.dendev.school_service.execption.TeacherException;
import com.dendev.school_service.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        Teacher teacher = teacherRepository.save(new Teacher(teacherDto));

        return new TeacherDto(teacher);
    }

    @Override
    public TeacherDto updateTeacher(Long id, TeacherDto teacherDto) {
        Teacher existingId = teacherRepository.findById(id).orElseThrow(()-> new TeacherException("Teacher Id "+ id + " not found!"));
        if (existingId != null){
            existingId.setName(teacherDto.getName());
            existingId.setRank(teacherDto.getRank());

            teacherRepository.save(existingId);
        }
        return new TeacherDto(existingId);

    }

    @Override
    public String deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
        return "Teacher Id "+ id +" has been deleted";
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Teacher existingId = teacherRepository.findById(id).orElseThrow(()-> new TeacherException("Teacher Id "+ id + "is not found!"));
        return new TeacherDto(existingId);
    }

    @Override
    public List<TeacherDto> getListOFTeachers() {
        List<TeacherDto> teacherDtoList = teacherRepository.findAll().stream().map(TeacherDto::new).collect(Collectors.toList());
        return teacherDtoList;
    }
}
