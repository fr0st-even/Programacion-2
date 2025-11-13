package com.example.studentsapi.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.studentsapi.model.Student;
import com.example.studentsapi.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import java.util.List;

class StudentServiceTest {

    @Test
    void testCreateStudent() {
        StudentRepository repo = mock(StudentRepository.class);
        StudentService service = new StudentService(repo);
        Student s = new Student();
        s.setNombre("Juan");
        s.setCorreo("juan@test.com");
        s.setNumeroTelefono("1234567890");
        s.setIdioma("español");
        when(repo.save(any(Student.class))).thenReturn(s);

        Student result = service.create(s);
        assertEquals("Juan", result.getNombre());
    }

    @Test
    void testGetAll() {
        StudentRepository repo = mock(StudentRepository.class);
        StudentService service = new StudentService(repo);
        when(repo.findAll()).thenReturn(List.of(new Student()));
        assertEquals(1, service.getAll().size());
    }
}
