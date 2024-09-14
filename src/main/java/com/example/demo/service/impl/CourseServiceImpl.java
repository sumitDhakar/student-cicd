package com.example.demo.service.impl;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.repo.CourseRepo;
import com.example.demo.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepo courseRepository;

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        // Convert List of Course entities to List of CourseDTO
        return courses.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return convertEntityToDTO(course);
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = convertDTOToEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return convertEntityToDTO(savedCourse);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setCourseName(courseDTO.getCourseName());
        course.setCourseCode(courseDTO.getCourseCode());
        course.setDescription(courseDTO.getDescription());
        course.setDuration(courseDTO.getDuration());

        Course updatedCourse = courseRepository.save(course);
        return convertEntityToDTO(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Conversion methods between Course and CourseDTO
    private CourseDTO convertEntityToDTO(Course course) {
        return new CourseDTO(course.getId(), course.getCourseName(), course.getCourseCode(),
                course.getDescription(), course.getDuration());
    }

    private Course convertDTOToEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseCode(courseDTO.getCourseCode());
        course.setDescription(courseDTO.getDescription());
        course.setDuration(courseDTO.getDuration());
        return course;
    }
}

