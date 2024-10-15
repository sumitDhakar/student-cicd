package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String courseCode;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private String description;
    private int duration;
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "course")
    private List<Grade> grades;

    @OneToMany(mappedBy = "course")
    private List<Attendance> attendances;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public List<Student> getStudents() {
        return students;
    }
}
