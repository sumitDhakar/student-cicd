package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.response.CustomResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {
    public Page<StudentDto> getAllStudents(int page, int size);

    StudentDto getStudentById(Long id);

    CustomResponse createStudent(StudentDto studentDTO);

    void deleteStudent(Long id);

    public StudentDto updateStudent(Long id, StudentDto studentDto);

    public List<StudentDto> searchStudents(String name, Integer age, String status);

    public StudentDto softDeleteStudent(Long id);

    public long countTotalStudents();
}
