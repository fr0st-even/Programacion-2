package com.example.studentsapi.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.studentsapi.model.Student;
import com.example.studentsapi.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@DisplayName("Pruebas del Servicio de Estudiantes")
class StudentServiceTest {

    @Mock
    private StudentRepository repo;

    @InjectMocks
    private StudentService service;

    private Student studentExample;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        studentExample = new Student();
        studentExample.setCarnet(12345L);
        studentExample.setNombre("Juan Pérez");
        studentExample.setCorreo("juan@test.com");
        studentExample.setNumeroTelefono("12345678");
        studentExample.setIdioma("español");
    }

    // ==================== PRUEBAS UNITARIAS ====================

    @Test
    @DisplayName("Crear estudiante exitosamente")
    void testCreateStudent() {
        when(repo.existsByCarnet(studentExample.getCarnet())).thenReturn(false);
        when(repo.findByCorreo(studentExample.getCorreo())).thenReturn(Optional.empty());
        when(repo.save(any(Student.class))).thenReturn(studentExample);

        Student result = service.create(studentExample);

        assertNotNull(result);
        assertEquals("Juan Pérez", result.getNombre());
        assertEquals("juan@test.com", result.getCorreo());
        verify(repo, times(1)).save(studentExample);
    }

    @Test
    @DisplayName("Crear estudiante con carnet duplicado debe lanzar excepción")
    void testCreateStudentWithDuplicateCarnet() {
        when(repo.existsByCarnet(studentExample.getCarnet())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> {
            service.create(studentExample);
        });

        verify(repo, never()).save(any());
    }

    @Test
    @DisplayName("Crear estudiante con correo duplicado debe lanzar excepción")
    void testCreateStudentWithDuplicateEmail() {
        when(repo.existsByCarnet(studentExample.getCarnet())).thenReturn(false);
        when(repo.findByCorreo(studentExample.getCorreo())).thenReturn(Optional.of(studentExample));

        assertThrows(IllegalArgumentException.class, () -> {
            service.create(studentExample);
        });

        verify(repo, never()).save(any());
    }

    @Test
    @DisplayName("Obtener todos los estudiantes")
    void testGetAll() {
        Student student2 = new Student();
        student2.setCarnet(67890L);
        student2.setNombre("María García");
        student2.setCorreo("maria@test.com");
        student2.setNumeroTelefono("87654321");
        student2.setIdioma("inglés");

        when(repo.findAll()).thenReturn(Arrays.asList(studentExample, student2));

        List<Student> result = service.getAll();

        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
    }

    @Test
    @DisplayName("Obtener estudiante por carnet exitosamente")
    void testGetByCarnet() {
        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));

        Student result = service.getByCarnet(12345L);

        assertNotNull(result);
        assertEquals(12345L, result.getCarnet());
        assertEquals("Juan Pérez", result.getNombre());
    }

    @Test
    @DisplayName("Obtener estudiante por carnet inexistente debe lanzar excepción")
    void testGetByCarnetNotFound() {
        when(repo.findByCarnet(99999L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            service.getByCarnet(99999L);
        });
    }

    @Test
    @DisplayName("Actualizar estudiante completamente")
    void testUpdateStudent() {
        Student updatedData = new Student();
        updatedData.setCarnet(12345L);
        updatedData.setNombre("Juan Pérez Actualizado");
        updatedData.setCorreo("juan.nuevo@test.com");
        updatedData.setNumeroTelefono("11111111");
        updatedData.setIdioma("francés");

        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        when(repo.save(any(Student.class))).thenReturn(updatedData);

        Student result = service.update(12345L, updatedData);

        assertEquals("Juan Pérez Actualizado", result.getNombre());
        assertEquals("juan.nuevo@test.com", result.getCorreo());
        verify(repo, times(1)).save(any(Student.class));
    }

    @Test
    @DisplayName("Actualizar estudiante con nuevo carnet")
    void testUpdateStudentWithNewCarnet() {
        Student updatedData = new Student();
        updatedData.setCarnet(54321L);
        updatedData.setNombre("Juan Pérez");
        updatedData.setCorreo("juan@test.com");
        updatedData.setNumeroTelefono("12345678");
        updatedData.setIdioma("español");

        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        when(repo.existsByCarnet(54321L)).thenReturn(false);
        when(repo.save(any(Student.class))).thenReturn(updatedData);

        Student result = service.update(12345L, updatedData);

        assertEquals(54321L, result.getCarnet());
    }

    @Test
    @DisplayName("Actualizar estudiante con carnet duplicado debe lanzar excepción")
    void testUpdateStudentWithDuplicateCarnet() {
        Student updatedData = new Student();
        updatedData.setCarnet(99999L);

        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        when(repo.existsByCarnet(99999L)).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> {
            service.update(12345L, updatedData);
        });
    }

    @Test
    @DisplayName("Actualización parcial - cambiar nombre")
    void testPatchStudentName() {
        Map<String, Object> updates = new HashMap<>();
        updates.put("nombre", "Pedro López");

        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        when(repo.save(any(Student.class))).thenReturn(studentExample);

        Student result = service.patch(12345L, updates);

        assertEquals("Pedro López", result.getNombre());
        verify(repo, times(1)).save(studentExample);
    }

    @Test
    @DisplayName("Actualización parcial - cambiar correo")
    void testPatchStudentEmail() {
        Map<String, Object> updates = new HashMap<>();
        updates.put("correo", "nuevo@test.com");

        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        when(repo.save(any(Student.class))).thenReturn(studentExample);

        Student result = service.patch(12345L, updates);

        assertEquals("nuevo@test.com", result.getCorreo());
    }

    @Test
    @DisplayName("Actualización parcial - cambiar teléfono")
    void testPatchStudentPhone() {
        Map<String, Object> updates = new HashMap<>();
        updates.put("numero_telefono", "99999999");

        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        when(repo.save(any(Student.class))).thenReturn(studentExample);

        Student result = service.patch(12345L, updates);

        assertEquals("99999999", result.getNumeroTelefono());
    }

    @Test
    @DisplayName("Actualización parcial - cambiar idioma")
    void testPatchStudentLanguage() {
        Map<String, Object> updates = new HashMap<>();
        updates.put("idioma", "inglés");

        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        when(repo.save(any(Student.class))).thenReturn(studentExample);

        Student result = service.patch(12345L, updates);

        assertEquals("inglés", result.getIdioma());
    }

    @Test
    @DisplayName("Actualización parcial - cambiar carnet")
    void testPatchStudentCarnet() {
        Map<String, Object> updates = new HashMap<>();
        updates.put("carnet", 54321L);

        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        when(repo.existsByCarnet(54321L)).thenReturn(false);
        when(repo.save(any(Student.class))).thenReturn(studentExample);

        Student result = service.patch(12345L, updates);

        assertEquals(54321L, result.getCarnet());
    }

    @Test
    @DisplayName("Actualización parcial con carnet duplicado debe lanzar excepción")
    void testPatchStudentWithDuplicateCarnet() {
        Map<String, Object> updates = new HashMap<>();
        updates.put("carnet", 99999L);

        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        when(repo.existsByCarnet(99999L)).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> {
            service.patch(12345L, updates);
        });
    }

    @Test
    @DisplayName("Eliminar estudiante exitosamente")
    void testDeleteStudent() {
        when(repo.existsByCarnet(12345L)).thenReturn(true);
        doNothing().when(repo).deleteByCarnet(12345L);

        assertDoesNotThrow(() -> {
            service.delete(12345L);
        });

        verify(repo, times(1)).deleteByCarnet(12345L);
    }

    @Test
    @DisplayName("Eliminar estudiante inexistente debe lanzar excepción")
    void testDeleteStudentNotFound() {
        when(repo.existsByCarnet(99999L)).thenReturn(false);

        assertThrows(NoSuchElementException.class, () -> {
            service.delete(99999L);
        });

        verify(repo, never()).deleteByCarnet(any());
    }

    // ==================== PRUEBAS DE INTEGRACIÓN ====================

    @Test
    @DisplayName("Integración: Crear y luego obtener estudiante")
    void testCreateAndGetStudent() {
        when(repo.existsByCarnet(studentExample.getCarnet())).thenReturn(false);
        when(repo.findByCorreo(studentExample.getCorreo())).thenReturn(Optional.empty());
        when(repo.save(any(Student.class))).thenReturn(studentExample);
        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));

        Student created = service.create(studentExample);
        Student retrieved = service.getByCarnet(created.getCarnet());

        assertEquals(created.getCarnet(), retrieved.getCarnet());
        assertEquals(created.getNombre(), retrieved.getNombre());
    }

    @Test
    @DisplayName("Integración: Crear, actualizar y verificar cambios")
    void testCreateUpdateAndVerify() {
        Student updatedStudent = new Student();
        updatedStudent.setCarnet(12345L);
        updatedStudent.setNombre("Nombre Actualizado");
        updatedStudent.setCorreo("actualizado@test.com");
        updatedStudent.setNumeroTelefono("11111111");
        updatedStudent.setIdioma("francés");

        when(repo.existsByCarnet(studentExample.getCarnet())).thenReturn(false);
        when(repo.findByCorreo(studentExample.getCorreo())).thenReturn(Optional.empty());
        when(repo.save(any(Student.class))).thenReturn(studentExample).thenReturn(updatedStudent);
        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample)).thenReturn(Optional.of(updatedStudent));

        service.create(studentExample);
        Student updated = service.update(12345L, updatedStudent);

        assertEquals("Nombre Actualizado", updated.getNombre());
        assertEquals("actualizado@test.com", updated.getCorreo());
    }

    @Test
    @DisplayName("Integración: Crear múltiples estudiantes y obtener todos")
    void testCreateMultipleAndGetAll() {
        Student student2 = new Student();
        student2.setCarnet(67890L);
        student2.setNombre("María García");
        student2.setCorreo("maria@test.com");
        student2.setNumeroTelefono("87654321");
        student2.setIdioma("inglés");

        when(repo.findAll()).thenReturn(Arrays.asList(studentExample, student2));

        List<Student> students = service.getAll();

        assertEquals(2, students.size());
        assertTrue(students.stream().anyMatch(s -> s.getCarnet().equals(12345L)));
        assertTrue(students.stream().anyMatch(s -> s.getCarnet().equals(67890L)));
    }

    // ==================== PRUEBAS E2E ====================

    @Test
    @DisplayName("E2E: Ciclo completo de vida de un estudiante")
    void testStudentFullLifecycle() {
        // Crear
        when(repo.existsByCarnet(studentExample.getCarnet())).thenReturn(false);
        when(repo.findByCorreo(studentExample.getCorreo())).thenReturn(Optional.empty());
        when(repo.save(any(Student.class))).thenReturn(studentExample);

        Student created = service.create(studentExample);
        assertNotNull(created);

        // Obtener
        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        Student retrieved = service.getByCarnet(12345L);
        assertEquals(created.getCarnet(), retrieved.getCarnet());

        // Actualizar parcialmente
        Map<String, Object> updates = new HashMap<>();
        updates.put("nombre", "Nombre Modificado");
        when(repo.save(any(Student.class))).thenReturn(studentExample);
        Student patched = service.patch(12345L, updates);
        assertEquals("Nombre Modificado", patched.getNombre());

        // Eliminar
        when(repo.existsByCarnet(12345L)).thenReturn(true);
        doNothing().when(repo).deleteByCarnet(12345L);
        assertDoesNotThrow(() -> service.delete(12345L));
    }

    @Test
    @DisplayName("E2E: Manejo de errores en operaciones CRUD")
    void testErrorHandlingE2E() {
        // Intentar obtener estudiante inexistente
        when(repo.findByCarnet(99999L)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> service.getByCarnet(99999L));

        // Intentar crear con carnet duplicado
        when(repo.existsByCarnet(12345L)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> service.create(studentExample));

        // Intentar eliminar estudiante inexistente
        when(repo.existsByCarnet(88888L)).thenReturn(false);
        assertThrows(NoSuchElementException.class, () -> service.delete(88888L));
    }

    @Test
    @DisplayName("E2E: Actualizar múltiples campos en secuencia")
    void testMultipleFieldUpdates() {
        when(repo.findByCarnet(12345L)).thenReturn(Optional.of(studentExample));
        when(repo.save(any(Student.class))).thenReturn(studentExample);

        // Actualizar nombre
        Map<String, Object> update1 = new HashMap<>();
        update1.put("nombre", "Nuevo Nombre");
        service.patch(12345L, update1);

        // Actualizar correo
        Map<String, Object> update2 = new HashMap<>();
        update2.put("correo", "nuevo@email.com");
        service.patch(12345L, update2);

        // Actualizar idioma
        Map<String, Object> update3 = new HashMap<>();
        update3.put("idioma", "francés");
        Student result = service.patch(12345L, update3);

        assertNotNull(result);
        verify(repo, times(3)).save(any(Student.class));
    }
}