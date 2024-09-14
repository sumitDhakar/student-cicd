package com.example.demo.service;

import com.example.demo.dto.GradeDTO;

import java.util.List;

public interface IGradeService {
    List<GradeDTO> getAllGrades();
    GradeDTO getGradeById(Long id);
    GradeDTO createGrade(GradeDTO gradeDTO);
    void deleteGrade(Long id);
}


