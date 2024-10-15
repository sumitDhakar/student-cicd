package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;




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

    public StudentDto(Long id, String name, int age, String gender, String address, String phone, String email, String password, String role, String status, Boolean isDeleted, Long departmentId, List<Long> courseIds, List<Long> gradeIds, List<Long> attendanceIds) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
        this.isDeleted = isDeleted;
        this.departmentId = departmentId;
        this.courseIds = courseIds;
        this.gradeIds = gradeIds;
        this.attendanceIds = attendanceIds;
    }

    public StudentDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public List<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Long> courseIds) {
        this.courseIds = courseIds;
    }

    public List<Long> getGradeIds() {
        return gradeIds;
    }

    public void setGradeIds(List<Long> gradeIds) {
        this.gradeIds = gradeIds;
    }

    public List<Long> getAttendanceIds() {
        return attendanceIds;
    }

    public void setAttendanceIds(List<Long> attendanceIds) {
        this.attendanceIds = attendanceIds;
    }

    private Long departmentId; // Only department ID instead of whole Department entity
    private List<Long> courseIds; // List of course IDs instead of the whole Course entity
    private List<Long> gradeIds; // List of grade IDs instead of the whole Grade entity
    private List<Long> attendanceIds; // List of attendance IDs instead of the whole Attendance entity
}
