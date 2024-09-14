package com.example.demo.repo;

import com.example.demo.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepo extends JpaRepository<Grade, Long>{
}
