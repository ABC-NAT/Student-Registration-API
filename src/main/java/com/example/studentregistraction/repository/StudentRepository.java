package com.example.studentregistraction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentregistraction.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

    boolean existsByStudentCode(String code);

    boolean existsByEmail(String email);

    Optional<Student> findByStudentCode(String studentCode);

    List<Student> findByFullNameContainingIgnoreCase(String keyword);

    void deleteByStudentCode(String studentCode);
}
