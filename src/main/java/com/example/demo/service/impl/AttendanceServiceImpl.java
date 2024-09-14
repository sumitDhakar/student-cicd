package com.example.demo.service.impl;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.entity.Attendance;
import com.example.demo.entity.Student;
import com.example.demo.repo.AttendanceRepo;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepository;

    @Autowired
    private StudentRepo studentRepository;

    @Override
    public List<AttendanceDTO> getAllAttendance() {
        List<Attendance> attendances = attendanceRepository.findAll();
        return attendances.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public AttendanceDTO getAttendanceById(Long id) {
        Attendance attendance = attendanceRepository.findById(id).orElse(null);
        return convertToDTO(attendance);
    }

    @Override
    public AttendanceDTO createAttendance(AttendanceDTO attendanceDTO) {
        Attendance attendance = convertToEntity(attendanceDTO);
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return convertToDTO(savedAttendance);
    }

    @Override
    public AttendanceDTO updateAttendance(Long id, AttendanceDTO attendanceDTO) {
        Attendance existingAttendance = attendanceRepository.findById(id).orElse(null);
        if (existingAttendance != null) {
            existingAttendance.setDate(attendanceDTO.getDate());
            existingAttendance.setStatus(attendanceDTO.getStatus());
            Student student = studentRepository.findById(attendanceDTO.getStudentId()).orElse(null);
            if (student != null) {
                existingAttendance.setStudent(student);
            }
            Attendance updatedAttendance = attendanceRepository.save(existingAttendance);
            return convertToDTO(updatedAttendance);
        }
        return null;
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    // Helper methods for converting between DTO and entity
    private AttendanceDTO convertToDTO(Attendance attendance) {
        AttendanceDTO attendanceDTO = new AttendanceDTO();
        attendanceDTO.setId(attendance.getId());
        attendanceDTO.setStudentId(attendance.getStudent().getId());
        attendanceDTO.setDate(attendance.getDate());
        attendanceDTO.setStatus(attendance.getStatus());
        return attendanceDTO;
    }

    private Attendance convertToEntity(AttendanceDTO attendanceDTO) {
        Attendance attendance = new Attendance();
        attendance.setDate(attendanceDTO.getDate());
        attendance.setStatus(attendanceDTO.getStatus());
        Student student = studentRepository.findById(attendanceDTO.getStudentId()).orElse(null);
        if (student != null) {
            attendance.setStudent(student);
        }
        return attendance;
    }
}
