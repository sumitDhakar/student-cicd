package com.example.demo.service.impl;

import com.example.demo.dto.FacultyDTO;
import com.example.demo.entity.Faculty;
import com.example.demo.repo.FacultyRepo;
import com.example.demo.service.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements IFacultyService {
    @Autowired
    private FacultyRepo facultyRepository;

    @Override
    public List<FacultyDTO> getAllFaculty() {
        List<Faculty> facultyList = facultyRepository.findAll();
        return facultyList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public FacultyDTO getFacultyById(Long id) {
        Faculty faculty = facultyRepository.findById(id).orElse(null);
        return convertToDTO(faculty);
    }

    
    @Override
    public FacultyDTO createFaculty(FacultyDTO facultyDTO) {
        Faculty faculty = convertToEntity(facultyDTO);
        faculty = facultyRepository.save(faculty);
        return convertToDTO(faculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    private FacultyDTO convertToDTO(Faculty faculty) {
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setId(faculty.getId());
        facultyDTO.setName(faculty.getName());
        facultyDTO.setContactInformation(faculty.getContactInformation());
        return facultyDTO;
    }

    private Faculty convertToEntity(FacultyDTO facultyDTO) {
        Faculty faculty = new Faculty();
        faculty.setId(facultyDTO.getId());
        faculty.setName(facultyDTO.getName());
        faculty.setContactInformation(facultyDTO.getContactInformation());
        return faculty;
    }
}

