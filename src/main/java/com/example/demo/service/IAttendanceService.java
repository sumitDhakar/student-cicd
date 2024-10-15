package com.example.demo.service;

import com.example.demo.dto.AttendanceDTO;
import lombok.Data;

import java.util.List;

public interface IAttendanceService {
    List<AttendanceDTO> getAllAttendance();
    AttendanceDTO getAttendanceById(Long id);
    AttendanceDTO createAttendance(AttendanceDTO attendanceDTO);
    AttendanceDTO updateAttendance(Long id, AttendanceDTO attendanceDTO);
    void deleteAttendance(Long id);
    public boolean wasStudentPresent(Long studentId, Data date);
}

