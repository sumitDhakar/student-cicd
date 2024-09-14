package com.example.demo.repo;

import com.example.demo.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
}
