package com.ejemplo.biblioteca.dto;

/**
 * Data Transfer Object for Persona entity
 */
public class PersonaDTO {
    private Long id;
    private String nombre;
    private String correo;

    // Default constructor
    public PersonaDTO() {
    }

    // Constructor with all fields
    public PersonaDTO(Long id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}