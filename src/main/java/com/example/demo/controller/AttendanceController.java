package com.example.demo.controller;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private IAttendanceService attendanceService;

    @GetMapping
    public List<AttendanceDTO> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/{id}")
    public AttendanceDTO getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @PostMapping
    public AttendanceDTO createAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        return attendanceService.createAttendance(attendanceDTO);
    }

    @PutMapping("/{id}")
    public AttendanceDTO updateAttendance(@PathVariable Long id, @RequestBody AttendanceDTO attendanceDTO) {
        return attendanceService.updateAttendance(id, attendanceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }
}
