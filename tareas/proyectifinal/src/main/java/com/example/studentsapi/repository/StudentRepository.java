package com.example.studentsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentsapi.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByCarnet(Long carnet);
    void deleteByCarnet(Long carnet);
    boolean existsByCarnet(Long carnet);
    Optional<Student> findByCorreo(String correo);
}