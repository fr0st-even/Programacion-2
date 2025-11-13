package com.example.studentsapi.controller;

import com.example.studentsapi.model.Student;
import com.example.studentsapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public java.util.List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{carnet}")
    public ResponseEntity<?> getByCarnet(@PathVariable Long carnet) {
        if (carnet < 1) {
            return ResponseEntity.badRequest().body("El carnet debe ser positivo");
        }
        try {
            return ResponseEntity.ok(service.getByCarnet(carnet));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Student s) {
        if (s.getCarnet() == null || s.getCarnet() < 1) {
            return ResponseEntity.badRequest().body("El carnet debe ser positivo");
        }
        Student created = service.create(s);
        return ResponseEntity
                .created(URI.create("/students/" + created.getCarnet()))
                .body(created);
    }

    @PutMapping("/{carnet}")
    public ResponseEntity<?> update(@PathVariable Long carnet, @Valid @RequestBody Student s) {
        if (carnet < 1 || s.getCarnet() == null || s.getCarnet() < 1) {
            return ResponseEntity.badRequest().body("El carnet debe ser positivo");
        }
        return ResponseEntity.ok(service.update(carnet, s));
    }

    @PatchMapping("/{carnet}")
    public ResponseEntity<?> patch(@PathVariable Long carnet, @RequestBody Map<String, Object> updates) {
        if (carnet < 1) {
            return ResponseEntity.badRequest().body("El carnet debe ser positivo");
        }
        return ResponseEntity.ok(service.patch(carnet, updates));
    }

    @DeleteMapping("/{carnet}")
    public ResponseEntity<?> delete(@PathVariable Long carnet) {
        if (carnet < 1) {
            return ResponseEntity.badRequest().body("El carnet debe ser positivo");
        }
        service.delete(carnet);
        return ResponseEntity.noContent().build();
    }
}