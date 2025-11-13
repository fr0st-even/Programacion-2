package com.example.studentsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(
        name = "students",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "correo"),
                @UniqueConstraint(columnNames = "carnet")
        }
)
public class Student {

    // ID interno, autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ESTE es el que ve el usuario (número de carné)
    @NotNull(message = "El carnet es obligatorio")
    @Min(value = 1, message = "El carnet debe ser un número positivo")
    private Long carnet;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 255, message = "El nombre no puede exceder 255 caracteres")
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato válido")
    @Column(unique = true)
    private String correo;

    @NotBlank(message = "El número de teléfono es obligatorio")
    @Pattern(regexp = "\\d{8}", message = "El número de teléfono debe tener exactamente 8 dígitos")
    @Column(name = "numero_telefono")
    private String numeroTelefono;

    @NotBlank(message = "El idioma es obligatorio")
    @Pattern(regexp = "inglés|español|francés", message = "Idioma no válido (use: inglés, español o francés)")
    private String idioma;

    public Long getId() { return id; }

    public Long getCarnet() { return carnet; }
    public void setCarnet(Long carnet) { this.carnet = carnet; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    @JsonProperty("numero_telefono")
    public String getNumeroTelefono() { return numeroTelefono; }

    @JsonProperty("numero_telefono")
    public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
}