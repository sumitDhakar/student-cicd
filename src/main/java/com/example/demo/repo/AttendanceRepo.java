package com.example.demo.repo;

import com.example.demo.entity.Attendance;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttendanceRepo extends JpaRepository<Attendance,Long> {

    Optional<Attendance> findByStudentIdAndDate(Long studentId, Data date);

}
