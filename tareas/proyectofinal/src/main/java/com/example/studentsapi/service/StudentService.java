package com.example.studentsapi.service;

import com.example.studentsapi.model.Student;
import com.example.studentsapi.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getByCarnet(Long carnet) {
        return repo.findByCarnet(carnet)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado"));
    }

    public Student create(Student s) {
        if (repo.existsByCarnet(s.getCarnet())) {
            throw new IllegalArgumentException("El carnet ya existe");
        }
        repo.findByCorreo(s.getCorreo()).ifPresent(x -> {
            throw new IllegalArgumentException("El correo ya existe");
        });
        return repo.save(s);
    }

    public Student update(Long carnetActual, Student datos) {
        Student actual = repo.findByCarnet(carnetActual)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado"));

        // si cambió el carnet, validar que no exista
        if (!datos.getCarnet().equals(carnetActual) && repo.existsByCarnet(datos.getCarnet())) {
            throw new IllegalArgumentException("El carnet nuevo ya está en uso");
        }

        actual.setCarnet(datos.getCarnet());
        actual.setNombre(datos.getNombre());
        actual.setCorreo(datos.getCorreo());
        actual.setNumeroTelefono(datos.getNumeroTelefono());
        actual.setIdioma(datos.getIdioma());

        return repo.save(actual);
    }

    public Student patch(Long carnetActual, java.util.Map<String, Object> updates) {
        Student actual = repo.findByCarnet(carnetActual)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado"));

        updates.forEach((k, v) -> {
            switch (k) {
                case "carnet" -> {
                    Long nuevoC = Long.valueOf(v.toString());
                    if (!nuevoC.equals(actual.getCarnet()) && repo.existsByCarnet(nuevoC)) {
                        throw new IllegalArgumentException("El carnet nuevo ya está en uso");
                    }
                    actual.setCarnet(nuevoC);
                }
                case "nombre" -> actual.setNombre((String) v);
                case "correo" -> actual.setCorreo((String) v);
                case "numero_telefono" -> actual.setNumeroTelefono((String) v);
                case "idioma" -> actual.setIdioma((String) v);
            }
        });

        return repo.save(actual);
    }

    @Transactional
    public void delete(Long carnet) {
        if (!repo.existsByCarnet(carnet)) {
            throw new NoSuchElementException("Estudiante no encontrado");
        }
        repo.deleteByCarnet(carnet);
    }
}