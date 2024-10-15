package com.example.demo.repo;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepo extends JpaRepository<Student, Long> {
    boolean existsByEmailOrPhone(String email, String phone);

    List<Student> findByNameContainingAndAgeAndStatus(String name, Integer age, String status);
    long count();
}
