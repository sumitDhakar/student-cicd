package com.example.demo.service.impl;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.response.CustomResponse;
import com.example.demo.entity.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.exceptionhandler.ResourceAlreadPersentException;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class StudentImpl implements IStudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentImpl.class);
    @Autowired
    private StudentRepo studentRepository;



    @Override
    public Page<StudentDto> getAllStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.map(this::convertToDTO);
    }

    @Override
    public List<StudentDto> searchStudents(String name, Integer age, String status) {
        List<Student> students = studentRepository.findByNameContainingAndAgeAndStatus(name, age, status);
        return students.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(Long id) {


        Student student = studentRepository.findById(id).orElse(null);
        return convertToDTO(student);
    }

    @Override
    public CustomResponse createStudent(StudentDto studentDTO) {
        // Check if a student with the same email or phone already exists
        if (studentRepository.existsByEmailOrPhone(studentDTO.getEmail(), studentDTO.getPhone())) {
            throw new ResourceAlreadPersentException("A student with this email or phone number already exists.");
        }

        // Convert DTO to Entity
        Student student = convertToEntity(studentDTO);

        // Save Entity
        student = studentRepository.save(student);

        // Convert Entity back to DTO
        StudentDto createdStudentDTO = convertToDTO(student);

        // Return success message with created student DTO
        return new CustomResponse("Student successfully created!", createdStudentDTO);
    }


    @Override
    public void deleteStudent(Long id) {
        // Check if the student exists
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with ID: " + id);
        }

        // Proceed to delete the student
        studentRepository.deleteById(id);
    }
    @Override
    public StudentDto softDeleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));

        // Mark as deleted
        student.setDeleted(true);
        Student updatedStudent = studentRepository.save(student);
        return convertToDTO(updatedStudent);
    }
    @Override
    public long countTotalStudents() {
        return studentRepository.count();
    }
@Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
         Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));

        // Update fields
        existingStudent.setName(studentDto.getName());
        existingStudent.setAge(studentDto.getAge());
        existingStudent.setGender(studentDto.getGender());
        existingStudent.setAddress(studentDto.getAddress());
        existingStudent.setPhone(studentDto.getPhone());
        existingStudent.setStatus(studentDto.getStatus());
              // Save updated student
        Student updatedStudent = studentRepository.save(existingStudent);
        return convertToDTO(updatedStudent);
    }

    private Student convertToEntity(StudentDto studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
//        student.setDepartment(studentDTO.getDepartment());
        student.setAddress(studentDTO.getAddress());
        student.setEmail(studentDTO.getEmail());
        student.setPhone(studentDTO.getPhone());
        student.setAge(studentDTO.getAge());
        student.setGender(studentDTO.getGender());
        student.setPassword(studentDTO.getPassword());
        student.setRole(studentDTO.getRole());
        student.setStatus(studentDTO.getStatus());
        return student;
    }

    private StudentDto convertToDTO(Student student) {
        StudentDto studentDTO = new StudentDto();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
//        studentDTO.setDepartment(student.getDepartment());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPhone(student.getPhone());
        studentDTO.setAge(student.getAge());
        studentDTO.setGender(student.getGender());
        studentDTO.setPassword(student.getPassword());
        studentDTO.setRole(student.getRole());
        studentDTO.setStatus(student.getStatus());
        return studentDTO;
    }

}
