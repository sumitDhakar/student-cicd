package com.example.demo.service;

import com.example.demo.dto.AttendanceDTO;

import java.util.List;

public interface IAttendanceService {
    List<AttendanceDTO> getAllAttendance();
    AttendanceDTO getAttendanceById(Long id);
    AttendanceDTO createAttendance(AttendanceDTO attendanceDTO);
    AttendanceDTO updateAttendance(Long id, AttendanceDTO attendanceDTO);
    void deleteAttendance(Long id);
}

