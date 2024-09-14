package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.response.CustomResponse;

import java.util.List;

public interface IStudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    CustomResponse createStudent(StudentDto studentDTO);
    void deleteStudent(Long id);
}
