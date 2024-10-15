package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.response.CustomResponse;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<Page<StudentDto>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<StudentDto> students = studentService.getAllStudents(page, size);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/create")
    public CustomResponse createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    @GetMapping("/search")
    public ResponseEntity<List<StudentDto>> searchStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String status) {

        List<StudentDto> students = studentService.searchStudents(name, age, status);
        return ResponseEntity.ok(students);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDto studentDto) {
        StudentDto updatedStudent = studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(updatedStudent);
    }
    @PatchMapping("/{id}/delete")
    public ResponseEntity<StudentDto> softDeleteStudent(@PathVariable Long id) {
        StudentDto updatedStudent = studentService.softDeleteStudent(id);
        return ResponseEntity.ok(updatedStudent);
    }
    @GetMapping("/count")
    public ResponseEntity<Long> countTotalStudents() {
        long totalCount = studentService.countTotalStudents();
        return ResponseEntity.ok(totalCount);
    }
}

