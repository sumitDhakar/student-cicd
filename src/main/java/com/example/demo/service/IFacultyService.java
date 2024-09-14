package com.example.demo.service;

import com.example.demo.dto.FacultyDTO;

import java.util.List;

public interface IFacultyService {
    List<FacultyDTO> getAllFaculty();
    FacultyDTO getFacultyById(Long id);
    FacultyDTO createFaculty(FacultyDTO facultyDTO);
    void deleteFaculty(Long id);
}

