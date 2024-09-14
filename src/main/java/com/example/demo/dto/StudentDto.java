package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String role;
    private String status;
    private Boolean isDeleted;

    private Long departmentId; // Only department ID instead of whole Department entity
    private List<Long> courseIds; // List of course IDs instead of the whole Course entity
    private List<Long> gradeIds; // List of grade IDs instead of the whole Grade entity
    private List<Long> attendanceIds; // List of attendance IDs instead of the whole Attendance entity
}
