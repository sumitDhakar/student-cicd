package com.example.demo.service.impl;

import com.example.demo.dto.GradeDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.repo.GradeRepo;
import com.example.demo.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeServiceImpl implements IGradeService {

    @Autowired
    private GradeRepo gradeRepository;

    @Override
    public List<GradeDTO> getAllGrades() {
        List<Grade> grades = gradeRepository.findAll();
        return grades.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public GradeDTO getGradeById(Long id) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        return convertToDTO(grade);
    }

    @Override
    public GradeDTO createGrade(GradeDTO gradeDTO) {
        Grade grade = convertToEntity(gradeDTO);
        grade = gradeRepository.save(grade);
        return convertToDTO(grade);
    }

    @Override
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }

    private GradeDTO convertToDTO(Grade grade) {
        GradeDTO gradeDTO = new GradeDTO();
        gradeDTO.setId(grade.getId());
        gradeDTO.setGrade(grade.getGrade());
//        gradeDTO.setStudentId(grade.getStudent().getId());
//        gradeDTO.setCourseId(grade.getCourse().getId());
        return gradeDTO;
    }

    private Grade convertToEntity(GradeDTO gradeDTO) {
        Grade grade = new Grade();
        grade.setId(gradeDTO.getId());
        grade.setGrade(gradeDTO.getGrade());

        Student student = new Student();
//        student.setId(gradeDTO.getStudentId());
        grade.setStudent(student);

        Course course = new Course();
//        course.setId(gradeDTO.getCourseId());
        grade.setCourse(course);

        return grade;
    }
}
